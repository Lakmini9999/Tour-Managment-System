package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.DBConnect;
import model.Destination;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TourController {

    @FXML  private DatePicker startDateDP,endDateDP;
    @FXML  private ComboBox<?> customerComboBox;
    @FXML  private ComboBox<Destination> destinationComboBox;
    @FXML  private ComboBox<?> guideComboBox;
    @FXML  private ComboBox<?> operatorComboBox;
    @FXML  private ComboBox<?> hotelComboBox;
    @FXML  private ComboBox<?> roomComboBox;

    private Main main;
    private ObservableList<Destination> destinationList= FXCollections.observableArrayList();
    private ObservableList combo = FXCollections.observableArrayList();
    private Connection con= DBConnect.dbConnection();

    public void initialize(){
        setDestinationComboBox();
       // destinationComboBox.setItems(combo);
        destinationComboBox.setItems(combo);

    }

    public void setTourView(Main main){
        this.main=main;
        //call the table view method here

    }

    public void setDestinationComboBox(){
        String getDestinationQuery="SELECT city_code,city_name FROM Destination;";
        int dbCityCode;
        String dbCityName;

        try {

            Statement getDestinationST = con.createStatement();
            getDestinationST.executeQuery(getDestinationQuery);
            ResultSet rsDestinations= getDestinationST.getResultSet();

            while (rsDestinations.next()){
                dbCityCode=rsDestinations.getInt("city_code");
                dbCityName=rsDestinations.getString("city_name");

                String list = dbCityCode + " "+dbCityName;
                //System.out.println(list);

                destinationList.add(new Destination(dbCityCode,dbCityName));
                combo.addAll(list);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }




}