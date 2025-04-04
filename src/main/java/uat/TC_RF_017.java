package uat;
//Verify whether the Password fields in the Register Account page are following Password Complexity Standards

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.time.Duration;
import java.util.Properties;

public class TC_RF_017 extends Base {
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
    public void teardown() {
        driver.quit();
    }


    @Test(dataProvider="passwordSupplier")
    public void verifyRegisteringAccountUsingPasswordsWhichAreNotFollowingPasswordComplexityStandards(String passwordText) {


        driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateBrandNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));

        driver.findElement(By.id("input-password")).sendKeys(passwordText);
        driver.findElement(By.id("input-confirm")).sendKeys(passwordText);

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarning = "Enter password which follows Password Complexity Standard!";

       // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedWarning);

    }

    @DataProvider(name="passwordSupplier")
    public Object[][] supplyPasswords() {

        Object[][] data = {{"12345"},{"abcdefghi"},{"abcd1234"},{"abcd123$"},{"ABCD456#"}};
        return data;

    }

}
