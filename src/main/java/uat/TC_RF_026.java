package uat;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TC_RF_026 extends Base {
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

    public void VerifyUIOfRegisterAccountPage(){

        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir") + "\\Screenshots\\expectedRegisterPageUI.png"));
        } catch (IOException e){
            e.printStackTrace();
        }



    }
}
