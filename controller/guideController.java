package controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import model.DBConnect;
import model.E_Pvalidation;
import model.guide;

/**
 * Created by hp on 5/15/2017.
 */
public class guideController {


        @FXML
        public Button ADD;
        @FXML
        private TextField g_license_id;
        @FXML
        private TextField g_name;
        @FXML
        private TextField g_salary;
        @FXML
        private TextField g_email;
        @FXML
        private TextField  g_access_level;
        @FXML
        private DatePicker  g_date_of_birth;
        @FXML
        private PasswordField g_password;

        @FXML
        public Button REMOVE;
        @FXML
        private TextField emp_id;
        @FXML
        private Label e_vaild;

        @FXML
        private Label pw_valid;


//adding values to data base

        public void ADD_to_database(){





            try{

                int licende_id =Integer.parseInt(g_license_id.getText());

                String password=g_password.getSelectedText() ;
                double salary=Double.parseDouble(g_salary.getText());
                String name=g_name.getText();
                String email=g_email.getText();
                LocalDate date_of_birth=g_date_of_birth.getValue() ;
                String access_level=g_access_level.getText();


                E_Pvalidation e1 = new E_Pvalidation();
                String result=e1.email_validation(email);
                String pw=e1.email_validation(password);
                if(result !=null|| pw!=null) {
                    e_vaild.setAccessibleRoleDescription(result);
                    pw_valid.setAccessibleRoleDescription(pw);
                }


                guide g1 = new guide();

                g1.Add_guide( licende_id, password, salary, name, email, date_of_birth, access_level);

            }
            catch(Exception e){


                System.out.println("values not passed");
                System.out.println( e);


            }

}


///remove record fom data base
            public void REMOVE_from_database(){

                try{

                    int ID =Integer.parseInt(emp_id.getText());

                    guide g2 = new guide();

                    g2.remove_guide(ID);


                }
            catch(Exception e){






            }






            }






}
