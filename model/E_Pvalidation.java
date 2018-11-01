package model;

/**
 * Created by hp on 5/17/2017.
 */
public class E_Pvalidation {


    public String email_validation(String eml) {

        String r =null;

        String email = eml;

        if ((email.contains(" ")))

        {
            r= "email adress cannot have any spaces .please enter valid email address";

        }
         else if ((email.contains("@"))&&(email.contains("."))&&(email.contains("com")))

        {

             r= "email validated";
        }

        else r="Invalid e-mail format.please enter a valid e-mail";


        return r;
    }

    public String password_validation(String pw ) {

        String p =null;


        if (pw.length() > 15 || pw.length() < 8)
        {
            p="Password should be less than 15 and more than 8 characters in length.";

        }
        String upperCaseletters = "(.*[A-Z].*)";
      if (!pw.matches(upperCaseletters ))
        {
            p="Password should contain at least one upper case alphabet";

        }
        String lowerCaseletters = "(.*[a-z].*)";
         if (!pw.matches(lowerCaseletters ))
        {
            p="Password should contain at least one lower case alphabet";

        }

        String numbers = "(.*[0-9].*)";
         if (!pw.matches(numbers ))
        {
            p="Password should contain at least one number.";

        }

        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
         if (!pw.matches(specialChars ))
        {
            p="Password should contain atleast one special character";

        }


         if ((pw.contains(" ")))

        {
            p= "password cannot have spaces please enter valid password";

        }

        else p="password validated";
        return p;
    }



}
