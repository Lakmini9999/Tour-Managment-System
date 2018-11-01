package model;
//import view.Availability.fxml;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.DBConnect;
import java.sql.ResultSet;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


public class Availability {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rt= null;


    private final StringProperty name;

    public  Availability(String gu_name) {
        this.name = new SimpleStringProperty(gu_name);
    }

        //getters
        public String getName()
        {
            return name.get();
        }


        //setters
        public void setName(String value)

        {
            name.set(value);
        }

        public StringProperty nameProperty (){return name;}





    public void tableload(String st_date, String e_date) {

        try {


            con = DBConnect.dbConnection();
            System.out.println("conn sucess");


            String j = "select g.guide_name \n" +
                    "from guide g LEFT OUTER join tour t on g.guide_employee_id=t.guide_employee_id\n" +
                    "where g.guide_employee_id not in(select t.guide_employee_id\n" +
                    "from tour t\n" +
                    "where t.start_date between '2017-05-01' AND'2017-05-04' OR t.end_date between '2017-05-01' AND'2017-05-04');\n" +
                    "\n" +
                    "";

            System.out.println("querry excecuted");

            pst = con.prepareStatement(j);

            System.out.println("querry excecuted111111");


            rt = pst.executeQuery();
            System.out.println("querry result ");

            //System.out.println(rt);

           // table1.setModel(DbUtils.resultSetToTableModel(rt));


        } catch (Exception e) {

            System.out.println("could ");


        }


    }
}
