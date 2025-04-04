package uat;
// Verify Registering an Account by using the Keyboard keys

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.time.Duration;
import java.util.Properties;

@Test

public class TC_RF_012 extends Base {
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
    public void VerifyRegisterAccountUsingKeywordKeys() {
        Actions actions = new Actions(driver);

        for (int i = 1; i <= 23; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys(prop.getProperty("firstName")).pause(Duration.ofSeconds(1));
        actions.sendKeys(prop.getProperty("firstName")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("lastName"))
                .sendKeys(Keys.TAB).sendKeys(CommonUtilities.generateBrandNewEmail())
                .sendKeys(Keys.TAB).sendKeys(prop.getProperty("telephoneNumber")).sendKeys(Keys.TAB)
                .sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

    }

}
