package temp;

import java.util.Date;

public class GenerateEmailDemo {
    public static void main(String[] args){
        Date date = new Date();
        String StringDate = date.toString();
        String noSpaceDateString = StringDate.replaceAll("\\s", "");
        String noColonStringDate = noSpaceDateString.replaceAll("\\:","");
        String emailWithTimeStamp = noColonStringDate+ "@gmail.com";
        System.out.println(emailWithTimeStamp);


    }
}
