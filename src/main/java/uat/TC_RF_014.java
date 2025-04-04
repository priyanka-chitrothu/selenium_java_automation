package uat;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

//Verify all the mandatory fields in the Register Account page are marked with red color * symbol
public class TC_RF_014 extends Base {
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
    public void VerifyAllRegisterPageMandatoryFiledsmarkedwithRedSymbool(){

        String expectedFNContent = "\"* \"";
        String exoectedFNColor = "rgb(255, 0, 0)";

        WebElement firstnameLabel =driver.findElement(By.cssSelector("label[for = 'input-firstname']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String fnContent =(String)jse.executeScript( "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstnameLabel);
        System.out.println(fnContent);

        String fnColor =(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstnameLabel);
        System.out.println(fnColor);

        Assert.assertEquals(fnContent, expectedFNContent);
        Assert.assertEquals(fnColor, exoectedFNColor);

        String expectedlnContent = "\"* \"";
        String exoectedlnColor = "rgb(255, 0, 0)";
        WebElement LastnameLabel = driver.findElement(By.cssSelector("label[for ='input-lastname']"));
        String lnContent =(String)jse.executeScript( "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", LastnameLabel);
        System.out.println(fnContent);

        String lnColor =(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", LastnameLabel);
        System.out.println(fnColor);

        Assert.assertEquals(lnContent, expectedlnContent);
        Assert.assertEquals(lnColor, exoectedlnColor);

    }

}
