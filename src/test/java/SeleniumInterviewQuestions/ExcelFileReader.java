package SeleniumInterviewQuestions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

public class ExcelFileReader {
   public static void main(String[] args) throws IOException {
       File src = new File("src/test/resources/readExelSheet.xlsx");
       FileInputStream fis = new FileInputStream(src);
       XSSFWorkbook wb = new XSSFWorkbook(fis);
       XSSFSheet sh1 = wb.getSheetAt(0);

       //sh1.getRow(0).createCell(3).setCellValue("Location");
       sh1.getRow(1).createCell(3).setCellValue("Hyderabad");
       sh1.getRow(2).createCell(3).setCellValue("Bangalore");
       sh1.getRow(3).createCell(3).setCellValue("Sri Lanka");
       sh1.getRow(4).createCell(3).setCellValue("America");
       for(Row row: sh1){
           for(Cell cell: row){
               System.out.println(cell.toString()+ "\t");
           }
           System.out.println(" ");

       }


   }
}
