package uat;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import utilis.CommonUtilities;

import java.util.Properties;

public class LoginPage extends Base {
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
        loginPage = landingPage.selectLoginOption();

    }
    public void verifyLogintoApplicationUsingValidCredentials(){
        Assert.assertTrue(landingPage.selectRegisterOption().didWeNavigateToRegisterAccountPage());



    }
}
