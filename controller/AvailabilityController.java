package controller;

/**
 * Created by hp on 5/15/2017.
 */

import java.net.URL;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Availability;
import model.DBConnect;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import model.Availability.*;
//import net.proteanit.sql.DbUtils;


public class AvailabilityController {



    public Button check;

    @FXML
    private DatePicker s_date;

    @FXML
    private DatePicker e_date;

    @FXML
    public  TableView <Availability> table1;
    @FXML
    public  TableColumn <Availability,String> NM;


    private ObservableList<Availability> data;
    private DBConnect db;



    @FXML
    public void Availability_check() {


       // Connection con = null;
        PreparedStatement pst = null;
        ResultSet rt = null;





        try {

            db= new DBConnect();

            LocalDate st_d = s_date.getValue();
            LocalDate en_d = e_date.getValue();

            String guides;

            Connection con =  db.dbConnection();
            data = FXCollections.observableArrayList();

            String j="select g.guide_name \n" +
                    "from guide g LEFT OUTER join tour t on g.guide_employee_id=t.guide_employee_id\n" +
                    "where g.guide_employee_id not in(select t.guide_employee_id\n" +
                    "from tour t\n" +
                    "where t.start_date between '"+st_d+"' AND'"+en_d+"' OR t.end_date between '"+st_d+"' AND'"+en_d+"');\n" +
                    "\n" +
                    "";
            pst = con.prepareStatement(j);


            rt =pst.executeQuery();

            while(rt.next()){

                guides=(rt.getString(5));


            data.add(new Availability(guides));



            }



        } catch (SQLException e) {




        }







    }

}
