package SeleniumInterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePicker {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void VerifySelectDatefromDatePicker(){
        driver.get("https://jqueryui.com/datepicker/");
        driver.findElement(By.xpath("//input[@id= 'datepicker']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("//span[@class= 'ui-icon ui-icon-circle-triangle-e']")).click();
        WebElement dateWidget = driver.findElement(By.xpath("//table[@class= 'ui-datepicker-calendar']"));
        List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        for(WebElement cell : columns){
            if(cell.getText().equals("13"));
            cell.findElement(By.linkText("13")).click();
            break;
        }
    }
}
