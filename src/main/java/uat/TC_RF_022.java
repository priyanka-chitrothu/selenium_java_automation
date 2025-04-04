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

public class TC_RF_022 extends Base {
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
    public void verifyVisiilityTogglingofPasswordFieldOnRegisterAccount(){
        Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("type"), "password");
        Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("type"), "password");

    }
}
