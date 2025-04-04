package uat;

//Verify the Breadcrumb, Page Heading, Page URL, Page Title of 'Register Account' Page
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

public class TC_RF_025 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        String browser = "chrome";
        if(browser == "chrome"){
            driver = new ChromeDriver();
        } else if (browser == "firefox") {
            driver = new FirefoxDriver();
        } else if (browser == "edge") {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");

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
    public void verifyRegisterPageBreadCrumbAndHeadingTitles(){

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class= 'breadcrumb']//a[text() = 'Register']")).isDisplayed());

        String expectedHeading = "Register Account";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id= 'content']/h1")).getText(), expectedHeading);

        String expectedURl = "https://tutorialsninja.com/demo/index.php?route=account/register";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);

        String expectedTitle = "Register Account";
        Assert.assertEquals(driver.getTitle() , expectedTitle);
    }
}
