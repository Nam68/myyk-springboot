package yk.web.myyk;

public class Test {

    public static void main(String[] args) {

        System.out.println("TESTTEST".substring(0,3).toLowerCase());
    }

    protected static String getMaskedEmail(String email) {

        String mask = "****";

        String[] emailSet = email.split("@");
        String localpart = emailSet[0];
        String domain = emailSet[1];

        String maskedLocalpart = localpart.substring(0, 4) + mask;
        String maskedEmail = maskedLocalpart + "@" + domain;


        return maskedEmail;
    }

}
