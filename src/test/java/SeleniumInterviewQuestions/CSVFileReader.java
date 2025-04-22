package SeleniumInterviewQuestions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CSVFileReader {
    public static void main(String[] args) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/data.csv"));
        List<String[]> li = reader.readAll();
        System.out.println("Total rows which we have"+ li.size());
        Iterator<String[]> i1 = li.iterator();
        while (i1.hasNext()){
            String[] str = i1.next();
            System.out.println("Values are");
            for(int i =0; i<str.length; i++){
                System.out.println(" "+str[i]);
            }
            System.out.println(" ");
        }




    }
}
