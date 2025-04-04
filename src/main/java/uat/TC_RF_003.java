package uat;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

// Verify account by providing the details
public class TC_RF_003 extends Base {
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
        if(driver!=null){
            driver.quit();
        }
    }
    @Test
    public void verifyRegisterAccountMandatoryFields() throws InterruptedException {

        driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateBrandNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

        String properDetailsOne = "Your Account Has Been Created!";
        String properDetailsTwo = "Congratulations! Your new account has been successfully created!";
        String properDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String properDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String properDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsOne));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsTwo));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsThree));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsFour));
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsFive));

        driver.findElement(By.linkText("Continue")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());



    }

}


