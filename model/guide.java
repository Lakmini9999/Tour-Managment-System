package model;

import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import model.DBConnect;
/**
 * Created by hp on 5/15/2017.
 */
public class guide {

    Connection con = null;
    PreparedStatement pst = null;


    public void Add_guide(
            int g_licende_id,
            String g_password,
            double g_salary,
            String g_name,
            String g_email,
            LocalDate g_date_of_birth,
            String g_access_level)
    {
        //int employee_id=g_id;
        int licende_id = g_licende_id;
        String password = g_password;
        double sal = g_salary;
        String name = g_name;
        String email = g_email;
        LocalDate date_of_birth = g_date_of_birth;
        String acc = g_access_level;

        System.out.print(licende_id);


        try {




            con = DBConnect.dbConnection();

            String q = "INSERT INTO guide(guide_licende_id,guide_password,salary,guide_name,guide_email,guide_date_of_birth, access_level) values('" + licende_id + "','" + password + "',' " + sal + "','" + name + "','" + email + "','" + date_of_birth + "','" + acc + "')";

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

    public void remove_guide(int guide_id){

        int employee_id = guide_id;


        try {

            con = DBConnect.dbConnection();

            String q = "DELETE\n" +
                    "FROM guide \n" +
                    "WHERE guide_employee_id = employee_id";

            System.out.println("query excecuted2222222");

            pst = con.prepareStatement(q);

            System.out.println("query excecuted33333");


            System.out.println("query excecuted11111");

            pst.execute();

            System.out.println("query excecuted");


        } catch (Exception e) {

            System.out.println("could not execute remove operation");


        }





    }




}

