package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilis.CommonUtilities;

import java.time.Duration;
import java.util.Properties;

public class Base {
    WebDriver driver;

    public WebDriver openBrowserApplication() {
        Properties prop = CommonUtilities.loadProperties();
        String browserName = prop.getProperty("browserName");
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(prop.getProperty("appURL"));
        //driver.get(prop.getProperty("appURL1"));
       // driver.get(prop.getProperty("appURL2"));
        //driver.get("http://localhost/opencart/");
        return  driver;

    }
}


