package uat;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilis.CommonUtilities;

import java.util.Properties;

public class LoginPageTest extends Base {
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    WebDriver driver;
    Properties prop;
    LandingPage landingPage;
    LoginPage loginPage;
    @Test
    @BeforeMethod
    public void setup(){
        driver = openBrowserApplication();
        prop = CommonUtilities.loadProperties();
        landingPage = new LandingPage(driver);
        landingPage.clickOnMyAccount();
        loginPage= landingPage.selectLoginOption();

    }
    @AfterMethod
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }
    public void verifyLogintoApplicationUsingValidCredentials(){
        Assert.assertTrue(landingPage.selectRegisterOption().didWeNavigateToRegisterAccountPage());
        loginPage.enterEmailText(prop.getProperty("existingEmailId"));
        loginPage.enterPasswordText(prop.getProperty("validPassword"));
        loginPage.clickOnLoginButton();



    }
}
