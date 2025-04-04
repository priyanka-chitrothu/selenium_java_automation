package uat;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_016 extends Base {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = openBrowserApplication();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @AfterMethod
    public void teardown(){
        if(driver!= null){
            driver.quit();
        }
    }
    @Test
    public void verifyRegisteringAccoutWithOnlySpaces(){

        driver.findElement(By.id("input-firstname")).sendKeys(" ");
        driver.findElement(By.id("input-lastname")).sendKeys(" ");
        driver.findElement(By.id("input-email")).sendKeys(" ");
        driver.findElement(By.id("input-telephone")).sendKeys(" ");
        driver.findElement(By.id("input-password")).sendKeys(" ");
        driver.findElement(By.id("input-confirm")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@name ='newsletter'][@value =1]")).click();
        driver.findElement(By.xpath("//input[@name ='agree'][@value =1]")).click();
        driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();

        String expectedFirstnameWarning = "First Name must be between 1 and 32 characters!";
        String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        String expectedPasswordWarning = "Password must be between 4 and 20 characters!!";

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id= 'input-firstname']//following-sibling::div")).getText(), expectedFirstnameWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id= 'input-lastname']//following-sibling::div")).getText(), expectedLastNameWarning);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(text(),'E-Mail Address does not appear to be valid!')])[1]")).getText(), expectedEmailWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()= 'Telephone must be between 3 and 32 characters!']")).getText(), expectedTelephoneWarning);




    }
}
