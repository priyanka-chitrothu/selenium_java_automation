package SeleniumInterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DynamicWebTable {
    WebDriver driver;
    Properties prop;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testWebtable_Test() throws Exception {
        driver.get("https://the-internet.herokuapp.com/tables");
//        JavascriptException js = (JavascriptException) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.linkText("")).click();
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id = 'table1']//tr//th"));
        System.out.println("Columns are:" + columns.size());
        for (WebElement col : columns) {
            System.out.println("columns are:" + col.getText());
        }
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'table1']//tr//th"));
        System.out.println("Number of rows:"+ rows.size());
        for(WebElement row: rows){
            System.out.println("Rows are:"+ row.getText());
        }
       // System.out.println("cell content is "+ selectTableContent());
    }
}

