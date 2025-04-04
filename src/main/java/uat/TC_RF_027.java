package uat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utilis.CommonUtilities;

import java.time.Duration;

public class TC_RF_027 {
    public void verifyRegisteringAccountInDifferentEnvironments(){
        String browserName = "chorme";
         if(browserName.equals("chrome")){
             WebDriver driver = new ChromeDriver();
         }else if(browserName.equals("firefox")){
             //driver = new FirefoxDriver();
         } else if (browserName.equals("edge")) {
            // driver = new EdgeDriver();

         }
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Arun");
        driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
        driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateBrandNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        driver.quit();
    }
    @DataProvider(name = "environmentSuppliers")
        public Object[][] passTestEnvironment(){
            Object[][] envs ={{"chrome"},{"firefox"}, {"edge"}};
            return envs;
        }
    }

