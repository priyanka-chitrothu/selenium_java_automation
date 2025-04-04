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

//Verify Registering an Account by entering different passwords into 'Password' and 'Password Confirm' fields
public class TC_RF_007 extends Base {
    WebDriver driver;
    Properties prop ;
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
    public void verifyNavigatingToRegisterAccountUsingMultipleWay(){

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//aside[@id='column-right']//a[text()='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

    }
}
