package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import model.Customer;
import model.E_Pvalidation;
import model.guide;

/**
 * Created by hp on 5/17/2017.
 */
public class CustomerController {



    @FXML
    private TextField c_name;

    @FXML
    private TextField c_email;

    @FXML
    private DatePicker c_date_of_birth;

    @FXML
    private TextField c_phone;

    @FXML
    public Button REMOVE;

    @FXML
    public TextField cus_id;

    @FXML
    private Label e_vaild;



    @FXML
    public Button Add_customer;



    public void add_customer(){


try{

        String name= c_name.getText();
        String email= c_email.getText();
        LocalDate date_of_birth= c_date_of_birth.getValue() ;
       int phone = Integer.parseInt(c_phone.getText());


         E_Pvalidation e1 = new E_Pvalidation();
        String result=e1.email_validation(email);

        if(result !=null) {
        e_vaild.setAccessibleRoleDescription(result);

    }

    Customer c1 = new Customer();

    c1.Add_customer( name, email, date_of_birth, phone);

}

catch (Exception e){



}
    }

    public void REMOVE_from_database(){

        try{


            int ID = Integer.parseInt(cus_id.getText());


            Customer c2 = new Customer();

            c2.remove_customer(ID);


        }

        catch (Exception e){



        }









    }




}
