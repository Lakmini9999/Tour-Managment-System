package model;

/**
 * Created by hp on 5/17/2017.
 */


import model.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class Customer {


    Connection con = null;
    PreparedStatement pst = null;


    public void Add_customer(


            String name,
            String email,
            LocalDate date_of_birth,
            int phone)

    {
        int Phone = phone;

        String Name = name;
        String Email = email;
        LocalDate Date_of_birth = date_of_birth;


        try {

            con = DBConnect.dbConnection();

            String q = "INSERT INTO Customer(customer_name,customer_email ,date_of_birth ,cust_phone ) values('" + Name + "','" + Email + "',' " + Date_of_birth + "','" + Phone + "')";

            System.out.println("query excecuted2222222");

            pst = con.prepareStatement(q);

            System.out.println("query excecuted33333");


            System.out.println("query excecuted11111");

            pst.execute();

            System.out.println("query excecuted");


        } catch (Exception e) {

            System.out.println("could not execute add operation");


        }

    }

    public void remove_customer(int cus_id){


        int customerID=cus_id;




        try {

            con = DBConnect.dbConnection();

            String q = "DELETE\n" +
                    "FROM Customer \n" +
                    "WHERE customer_id  = customerID";

            System.out.println("query excecuted2222222");

            pst = con.prepareStatement(q);

            System.out.println("query excecuted33333");


            System.out.println("query excecuted11111");

            pst.execute();

            System.out.println("query excecuted");


        }

        catch (Exception e) {

            System.out.println("could not execute remove operation");


        }


}

}