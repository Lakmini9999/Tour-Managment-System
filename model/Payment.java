package model;

/**
 * Created by Gayan Kalinga on 10-May-17.
 */
public class Payment {

    private int tourID,customerID;
    private float amount;
    private String method,dateOfPyt;

    public Payment(int tourID,int customerID, float amount, String method, String dateOfPyt){
        this.tourID=tourID;
        this.customerID=customerID;
        this.amount=amount;
        this.method=method;
        this.dateOfPyt=dateOfPyt;
    }

    //Getter Method
    public int getTourID(){return tourID;}
    public int getCustomerID(){return  customerID;}
    public float getAmount(){return amount;}
    public String getMethod(){return method;}
    public String  getDateOfPyt(){return dateOfPyt;}

    //Setter Method
    public void setTourID(int tourID){this.tourID=tourID;}
    public void setCustomerID(int customerID){this.customerID=customerID;}
    public void setAmount(float amount){this.amount=amount;}
    public void setDateOfPyt(String dateOfPyt){this.dateOfPyt=dateOfPyt;}
    public void setMethod(String method){this.method=method;}


}
