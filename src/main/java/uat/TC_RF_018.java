package uat;

//Verify whether the fields in the Register Account page are according the Client requirements (Examples- Height, Width, Number of characters etc.)

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TC_RF_018 extends Base {
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
    @Test
    public void verifyHeightWidthNumberOfCharacters() throws IOException {

        String expectedHeight = "34px";
        String expectedWidth = "701.25px";

        //First Name Field check

        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        String actualFirstNameFieldHeight = firstNameField.getCssValue("height");
        Assert.assertEquals(actualFirstNameFieldHeight, expectedHeight);
        String actualFirstNameWidth = firstNameField.getCssValue("width");
        Assert.assertEquals(actualFirstNameWidth, expectedWidth);

        String exptectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), exptectedFirstNameWarning);
        firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys("a");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean firstNameWarningStatus = false;
        try {
            firstNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            firstNameWarningStatus = false;
        }
        Assert.assertFalse(firstNameWarningStatus);
        firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.clear();
        firstNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeab");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        firstNameWarningStatus = false;
        try {
            firstNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            firstNameWarningStatus = false;
        }
        Assert.assertFalse(firstNameWarningStatus);
        firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.clear();
        firstNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabc");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), exptectedFirstNameWarning);

        //Last Name Field check

        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        String actualLastNameFieldHeight = lastNameField.getCssValue("height");
        Assert.assertEquals(actualLastNameFieldHeight, expectedHeight);
        String actualLastNameWidth = lastNameField.getCssValue("width");
        Assert.assertEquals(actualLastNameWidth, expectedWidth);

        String exptectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), exptectedLastNameWarning);
        lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys("a");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean lastNameWarningStatus = false;
        try {
            lastNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            lastNameWarningStatus = false;
        }
        Assert.assertFalse(lastNameWarningStatus);
        lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.clear();
        lastNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeab");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        lastNameWarningStatus = false;
        try {
            lastNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            lastNameWarningStatus = false;
        }
        Assert.assertFalse(lastNameWarningStatus);
        lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.clear();
        lastNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabc");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), exptectedLastNameWarning);

        //Email Field check

        WebElement emailField = driver.findElement(By.id("input-email"));
        String actualEmailFieldHeight = emailField.getCssValue("height");
        Assert.assertEquals(actualEmailFieldHeight,expectedHeight);
        String actualEmailFieldWidth = emailField.getCssValue("width");
        Assert.assertEquals(actualEmailFieldWidth, expectedWidth);
        emailField.sendKeys("adfdsfasdfadfdsssssafasdfasdfasdfadsfasdf@email.com");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean emailWarningStatus = false;
        try {
            emailWarningStatus = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            emailWarningStatus = false;
        }
        Assert.assertFalse(emailWarningStatus);

        //Telephone Field check

        WebElement telephoneField = driver.findElement(By.id("input-telephone"));
        String actualTelephoneFieldHeight = telephoneField.getCssValue("height");
        Assert.assertEquals(actualTelephoneFieldHeight,expectedHeight);
        String actualTelephoneFieldWidth = telephoneField.getCssValue("width");
        Assert.assertEquals(actualTelephoneFieldWidth, expectedWidth);

        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
        telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.sendKeys("1");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
        telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.clear();
        telephoneField.sendKeys("12");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
        telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.clear();
        telephoneField.sendKeys("123");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean telephoneWarningStatus = false;
        try {
            telephoneWarningStatus = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            telephoneWarningStatus = false;
        }
        Assert.assertFalse(telephoneWarningStatus);
        telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.clear();
        telephoneField.sendKeys("12345678901234567890123456789012");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        telephoneWarningStatus = false;
        try {
            telephoneWarningStatus = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            telephoneWarningStatus = false;
        }
        Assert.assertFalse(telephoneWarningStatus);
        telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.clear();
        telephoneField.sendKeys("123456789012345678901234567890123");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);

        //Password Field check
        WebElement passwordField = driver.findElement(By.id("input-password"));
        String actualPasswordFieldHeight = passwordField.getCssValue("height");
        Assert.assertEquals(actualPasswordFieldHeight,expectedHeight);
        String actualPasswordFieldWidth = passwordField.getCssValue("width");
        Assert.assertEquals(actualPasswordFieldWidth, expectedWidth);
        String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);

        passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("1");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
        passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("12");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
        passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("123");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
        passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("1234");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean passwordWarningStatus = false;
        try {
            passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            passwordWarningStatus = false;
        }
        Assert.assertFalse(passwordWarningStatus);
        passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("12345678901234567890");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        passwordWarningStatus = false;
        try {
            passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            passwordWarningStatus = false;
        }
        Assert.assertFalse(passwordWarningStatus);

        passwordField = driver.findElement(By.id("input-password"));
        passwordField.clear();
        passwordField.sendKeys("123456789012345678901");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        passwordWarningStatus = false;
        try {
            passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed();
        }catch(NoSuchElementException e) {
            passwordWarningStatus = false;
        }
        Assert.assertTrue(passwordWarningStatus);

        //Password Confirm Field check
        WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
        String actualPasswordConfirmFieldHeight = passwordConfirmField.getCssValue("height");
        Assert.assertEquals(actualPasswordConfirmFieldHeight,expectedHeight);
        String actualPasswordConfirmFieldWidth = passwordConfirmField.getCssValue("width");
        Assert.assertEquals(actualPasswordConfirmFieldWidth,expectedWidth);

        //Continue Button
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        String actualButtonTextColor = continueButton.getCssValue("color");
        Assert.assertEquals(actualButtonTextColor,"rgba(255, 255, 255, 1)");
        String actualButtonBackgroundColor = continueButton.getCssValue("background-color");
        Assert.assertEquals(actualButtonBackgroundColor,"rgba(34, 154, 200, 1)");
        String actualButtonFontSize = continueButton.getCssValue("font-size");
        Assert.assertEquals(actualButtonFontSize,"12px");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcScreenshot,new File(System.getProperty("user.dir")+"\\Screenshots\\AcutalRAPageAligment.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(CommonUtilities.compareTwoScreenShots(System.getProperty("user.dir")+"\\Screenshots\\AcutalRAPageAligment.png", System.getProperty("user.dir")+"\\Screenshots\\ExpectedRAPageAligment.png"));

    }

    }

