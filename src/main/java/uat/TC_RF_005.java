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
import java.util.Date;
import java.util.Properties;
import java.util.prefs.BackingStoreException;

//Verify Registering an Account when 'Yes' option is selected for Newsletter field
public class TC_RF_005 extends Base {
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
    public void verifyRegisteringAccountBySubscribingToNewsletter(){

        driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateBrandNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();

        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());



    }


}
