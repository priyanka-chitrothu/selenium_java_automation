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

public class TC_RF_019 extends Base {
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
    public void verifyLeadingAndTrailingSpacesWhileRegisteringAccount(){

         String enteredFirstName= "   " + prop.getProperty("firstName")+ "  ";
         driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstName);
         String enteredLastName = "   " + prop.getProperty("lastName")+ "  ";
         driver.findElement(By.id("input-lastname")).sendKeys(enteredLastName);
         String enteredEmail = "   "+ CommonUtilities.generateBrandNewEmail();
         driver.findElement(By.id("input-email")).sendKeys(enteredEmail);
         String enteredTelephone = "   " + prop.getProperty("telephoneNumber")+ "  ";
         driver.findElement(By.id("input-telephone")).sendKeys(enteredTelephone);
         driver.findElement(By.id("input-password")).sendKeys("validPassword");
         driver.findElement(By.id("input-confirm")).sendKeys("validPassword");
         driver.findElement(By.id("input-confirm")).sendKeys(" ");
         driver.findElement(By.xpath("//input[@name ='newsletter'][@value =1]")).click();
         driver.findElement(By.name("agree")).click();
         driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();

         driver.findElement(By.linkText("Edit your account information")).click();
         Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), enteredFirstName.trim());
         Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), enteredLastName.trim());
         Assert.assertEquals( driver.findElement(By.id("input-email")).getAttribute("value"), enteredEmail);
         Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), enteredTelephone);
     }
}
