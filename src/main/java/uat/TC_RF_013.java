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
import utilis.CommonUtilities;

import java.time.Duration;
import java.util.Properties;

//Verify all the fields in the Register Account page have the proper placeholders
public class TC_RF_013 extends Base {
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
    public void  VerifyPlaceholderInTextFields(){

        String expectedFirstNamePlaceHolderText = "First Name";
        Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), expectedFirstNamePlaceHolderText);

        String expectedLastNamePlaceHolderText = "Last Name";
        Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), expectedLastNamePlaceHolderText);

        String expectedEmail = "E-Mail";
        Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), expectedEmail);

        String expectedTelephonePlacehole = "Telephone";
        Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expectedTelephonePlacehole);

        String expectedPasswordPlaceholder = "Password";
        Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),expectedPasswordPlaceholder);

        String expectedPasswordConfirmPlaceholderText = "Password Confirm";
        Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expectedPasswordConfirmPlaceholderText);

    }
}
