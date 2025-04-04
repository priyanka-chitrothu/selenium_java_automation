package uat;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


//Verify Registering an Account by providing an invalid email address into the E-Mail field
public class TC_RF_010 extends Base {
    WebDriver driver;
    Properties prop;
    @BeforeMethod
    public void setup(){
        driver = openBrowserApplication();
        prop = CommonUtilities.loadProperties();
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
    public void  VerifyProvidingInvalidaEmailAddress() throws InterruptedException, IOException {
        driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys("amotoori");
        driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessageOne = "Please include an '@' in the email address. 'amotoori' is missing an '@'.";
        String actualWarningMessageOne = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
        Assert.assertEquals(actualWarningMessageOne, expectedWarningMessageOne);

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("amotoori@");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessageTwo = "Please enter a part following '@'. 'amotoori@' is incomplete.";
        String actualWarningMessageTwo = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
        Assert.assertEquals(actualWarningMessageTwo, expectedWarningMessageTwo);

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("amotoori@gmail");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessageThree = "E-Mail Address does not appear to be valid!";
        String actualWarningMessageThree = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
        Assert.assertEquals(actualWarningMessageThree, expectedWarningMessageThree);

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("amotoori@gmail.");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
        String actualWarningMessageFour = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
        Assert.assertEquals(actualWarningMessageFour, expectedWarningMessageFour);

//        driver.findElement(By.id("input-firstname")).sendKeys("Arun");
//        driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
//        driver.findElement(By.id("input-email")).sendKeys("amotoori1@gmail");
//        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
//        driver.findElement(By.id("input-password")).sendKeys("12345");
//        driver.findElement(By.id("input-confirm")).sendKeys("12345");
//        driver.findElement(By.xpath("//input[@name = 'newsletter'][@value=1]")).click();
//        driver.findElement(By.name("agree")).click();
//
//        driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();
//
//        Thread.sleep(3000);
//        File srcScreenshot =  driver.findElement(By.xpath("//form[@class = 'form-horizontal']")).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\ScreenShots\\sc1Actual.png"));
//        String expectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
//        String actualWarningMessageFour = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
//        Assert.assertEquals(actualWarningMessageFour, expectedWarningMessageFour);

    }
}
