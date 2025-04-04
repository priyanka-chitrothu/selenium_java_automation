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

public class TC_RF_023 extends Base {
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
    public void verifyWorkingofEveryLinkonRegisterAccountPage() {

        driver.findElement(By.xpath("//a/i[@class= 'fa fa-phone']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class= 'breadcrumb']//a[text() = 'Contact Us']")).isDisplayed());

        driver.navigate().back();

        driver.findElement(By.xpath("//a/i[@class= 'fa fa-heart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class= 'breadcrumb']//a[text() = 'Login']")).isDisplayed());

        driver.navigate().back();

        driver.findElement(By.xpath("//span[text()= 'Shopping Cart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text() = 'Shopping Cart']")).isDisplayed());

        driver.navigate().back();

        driver.findElement(By.xpath("//span[text() = 'Checkout']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text() = 'Shopping Cart']")).isDisplayed());
        driver.navigate().back();

        driver.findElement(By.xpath("//button[@class= 'btn btn-default btn-lg']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text() = 'Search']")).isDisplayed());
        driver.navigate().back();

        driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text() = 'Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text() = 'Register']")).isDisplayed());


    }
}
