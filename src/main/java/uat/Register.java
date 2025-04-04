package uat;

import base.Base;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utilis.CommonUtilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Register extends Base {
    WebDriver driver;
    Properties prop;
    LandingPage landingPage;
    RegisterPage registerPage;
    AccountSuccesspage accountSuccesspage;
    AccountPage accountPage;
    NewsLetterPage newsletterPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = openBrowserApplication();
        prop = CommonUtilities.loadProperties();
        landingPage = new LandingPage(driver);
        landingPage.clickOnMyAccount();
        registerPage = landingPage.selectRegisterOption();
        accountPage = new AccountPage(driver);
        accountSuccesspage = new AccountSuccesspage(driver);
        newsletterPage = new NewsLetterPage(driver);
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }

    @Test(priority = 1, enabled = false)
    public void verifyRegisterAccountWithMandatoryFields() throws InterruptedException {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accountSuccesspage.isUserLoggedIn());
//        Thread.sleep(500); // Optional - wait to ensure scroll completion
        Assert.assertTrue(accountSuccesspage.isUserLoggedIn());

        String expectedHeading = "Your Account Has Been Created!";
        Assert.assertEquals(accountSuccesspage.getPageHeading(), expectedHeading);

        String expectedProperDetailsOne = "Your Account Has Been Created!";
        String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
        String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

        String actualContent = accountSuccesspage.getPageContent();

        Assert.assertTrue(actualContent.contains(expectedProperDetailsOne));
        Assert.assertTrue(actualContent.contains(expectedProperDetailsTwo));
        Assert.assertTrue(actualContent.contains(expectedProperDetailsThree));
        Assert.assertTrue(actualContent.contains(expectedProperDetailsFour));
        Assert.assertTrue(actualContent.contains(expectedProperDetailsFive));

        accountSuccesspage.clickOnContinueButton();
        //accountPage = accountSuccesspage.clickOnContinueButton();
        accountPage.didWeNavigateToAccountPage();
    }

@Test(priority = 3, enabled = false)
public void verifyRegisterAccountMandatoryFields()  {

    registerPage.enterFirstName(prop.getProperty("firstName"));
    registerPage.enterLastName(prop.getProperty("lastName"));
    registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
    registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
    registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
    registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
    registerPage.selectYesNewletterOption();
    registerPage.selectPrivacyPolicyFiled();
    accountSuccesspage = registerPage.clickOnContinueButton();

    Assert.assertTrue(accountSuccesspage.isUserLoggedIn());
    Assert.assertTrue(accountSuccesspage.didWeNavigateToAccountSuccessPage());

    String expectedProperDetailsOne = "Your Account Has Been Created!";
    String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
    String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
    String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
    String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
    String actualProperDetails = accountSuccesspage.getPageContent();
    Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
    Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
    Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
    Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
    Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));

    accountSuccesspage.clickOnContinueButton();
    //accountPage = accountSuccesspage.clickOnContinueButton();
    accountPage.didWeNavigateToAccountPage();

}
    @Test(priority = 4, enabled = false)
    public void verifyWarningMessageOfMandatoryFieldsInRegisterAccountPage() {

        registerPage.clickOnContinueButton();
        String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
        String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
        String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

        Assert.assertEquals(registerPage.getFirstNameWarning(), expectedFirstNameWarning);
        Assert.assertEquals(registerPage.getLastNameWarning(), expectedLastNameWarning);
        Assert.assertEquals(registerPage.getEmailWarning(), expectedEmailWarning);
        Assert.assertEquals(registerPage.getTelePhoneWarning(), expectedTelephoneWarning);
        Assert.assertEquals(registerPage.getPasswordWarning(), expectedPasswordWarning);
        Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedPrivacyPolicyWarning);

    }

    @Test(priority = 5, enabled = false)
    public void verifyRegisteringAccountBySubscribingToNewsletter(){

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();
//        accountSuccesspage = registerPage.clickOnContinueButton();
        newsletterPage = accountSuccesspage.selectSubscribeUnsubscribeOption();

        Assert.assertTrue(newsletterPage.didWeNavigateToBreadCrumbPage());
        Assert.assertTrue(newsletterPage.yesNewletterOptionSelected());
    }
    @Test(priority = 6, enabled = false)
    public void verifyRegisteringAccountByselectingNoToNewsletter(){
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        driver.findElement(By.name("agree")).click();
        accountSuccesspage = registerPage.clickOnContinueButton();
        accountSuccesspage.clickOnContinueButton();
        newsletterPage = accountSuccesspage.selectSubscribeUnsubscribeOption();

        Assert.assertTrue(newsletterPage.didWeNavigateToBreadCrumbPage());
        Assert.assertTrue(newsletterPage.noNewsletterOptionSelected());

    }
    @Test(priority = 7, enabled = false)
    public void verifyNavigatingToRegisterAccountUsingMultipleWay(){

        Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());
        registerPage.clickOnMyAccount();
        registerPage.selectLoginOption();
        loginPage = registerPage.selectLoginOption();
        loginPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());

        registerPage.clickOnMyAccount();
        registerPage.selectLoginOption();
        loginPage = registerPage.selectLoginOption();
        loginPage.clickOnRegisterOption();
        Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());

    }
    @Test(priority = 8, enabled = false)
    public  void VerifyRegisterAccountByProvidingMismatchPassword(){

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("mismatchingPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage =registerPage.clickOnContinueButton();

        String expectedWarningMessage = "Password confirmation does not match password!";
        Assert.assertEquals(registerPage.getPasswordWarning(), expectedWarningMessage);
    }
    @Test(priority = 9, enabled = false)
    public void VerifyRegisteringWithExistingEmailAccount(){

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(prop.getProperty("existingEmailId"));
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();
       // accountSuccesspage.clickOnContinueButton();

        String ExpectedWarningMessage = "Warning: E-Mail Address is already registered!";
        Assert.assertEquals(registerPage.getAlreadyExistEmailWarning(), ExpectedWarningMessage);
    }
    @Test(priority = 10, enabled = false)
    public void  VerifyProvidingInvalidaEmailAddress() throws InterruptedException, IOException {
        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(prop.getProperty("invalidEmailId1"));
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();
       // accountSuccesspage.clickOnContinueButton();


        String expectedWarningMessageOne = "Please include an '@' in the email address. 'amotoori' is missing an '@'.";
        String actualWarningMessageOne = registerPage.getEmailValidationMessage();
        Assert.assertEquals(actualWarningMessageOne, expectedWarningMessageOne);


        registerPage.clearEmailField();
        registerPage.enterEmailId(prop.getProperty("invalidEmailId2"));
        registerPage.clickOnContinueButton();


        String expectedWarningMessageTwo = "Please enter a part following '@'. 'amotoori@' is incomplete.";
        String actualWarningMessageTwo = registerPage.getEmailValidationMessage();
        Assert.assertEquals(actualWarningMessageTwo, expectedWarningMessageTwo);

        registerPage.clearEmailField();
        registerPage.enterEmailId(prop.getProperty("invalidEmailId3"));
        registerPage.clickOnContinueButton();

        String expectedWarningMessageThree = "E-Mail Address does not appear to be valid!";
        String actualWarningMessageThree = registerPage.getEmailValidationMessage();
        Assert.assertEquals(actualWarningMessageThree, expectedWarningMessageThree);

        registerPage.clearEmailField();
        registerPage.enterEmailId(prop.getProperty("invalidEmailId4"));
        registerPage.clickOnContinueButton();

        String expectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
        String actualWarningMessageFour = registerPage.getEmailValidationMessage();
        Assert.assertEquals(actualWarningMessageFour, expectedWarningMessageFour);

    }
    @Test(priority = 11, enabled = false)
    public void VerifyRegisteringaccountwithInvalidTelephoneNumber() throws InterruptedException{

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("invalidtelephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();

        String expectedWarningMessage = "Telephone number entered by you is invalid!";
        // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText(), expectedWarningMessage);
    }
    @Test(priority = 12)
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

        Assert.assertTrue(accountSuccesspage.isUserLoggedIn());
        Assert.assertTrue(accountSuccesspage.didWeNavigateToAccountSuccessPage());

    }
    @Test(priority = 13)
    public void  VerifyPlaceholderInTextFields(){

        String expectedFirstNamePlaceHolderText = "First Name";
        Assert.assertEquals(registerPage.firstNamePlaceholder(), expectedFirstNamePlaceHolderText);

        String expectedLastNamePlaceHolderText = "Last Name";
        Assert.assertEquals(registerPage.lastNamePlaceholder(), expectedLastNamePlaceHolderText);

        String expectedEmail = "E-Mail";
        Assert.assertEquals(registerPage.emailIdPlaceholder(), expectedEmail);

        String expectedTelephonePlaceholder = "Telephone";
        Assert.assertEquals(registerPage.telephonePlaceholder(), expectedTelephonePlaceholder);

        String expectedPasswordPlaceholder = "Password";
        Assert.assertEquals(registerPage.emailIdPlaceholder(),expectedPasswordPlaceholder);

        String expectedPasswordConfirmPlaceholderText = "Password Confirm";
        Assert.assertEquals(registerPage.passwordConfirmPlaceholder(), expectedPasswordConfirmPlaceholderText);

    }
    @Test(priority = 14)
    public void VerifyAllRegisterPageMandatoryFiledsmarkedwithRedSymbool(){

        String expectedFNContent = "\"* \"";
        String exoectedFNColor = "rgb(255, 0, 0)";
        Assert.assertEquals(registerPage.getFirstNameContent(driver), expectedFNContent);
        Assert.assertEquals(registerPage.getFirstNameLabelColor(driver), exoectedFNColor);

        String expectedlnContent = "\"* \"";
        String exoectedlnColor = "rgb(255, 0, 0)";
        Assert.assertEquals(registerPage.getLastNameContent(driver), expectedlnContent);
        Assert.assertEquals(registerPage.getLastNameLabelColor(driver), exoectedlnColor);

    }
    @Test(priority = 16, enabled = false)
    public void verifyRegisteringAccoutWithOnlySpaces(){

        registerPage.enterFirstName(" ");
        registerPage.enterLastName(" ");
        registerPage.enterEmailId(" ");
        registerPage.enterTelephoneNumber(" ");
        registerPage.enterPasswordFiled(" ");
        registerPage.enterPasswordConfirmField(" ");
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();

        String expectedFirstnameWarning = "First Name must be between 1 and 32 characters!";
        String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        //String expectedPasswordWarning = "Password must be between 4 and 20 characters!!";

        Assert.assertEquals(registerPage.getFirstNameWarning(), expectedFirstnameWarning);
        Assert.assertEquals(registerPage.getLastNameWarning(), expectedLastNameWarning);
        Assert.assertEquals(registerPage.getEmailWarning(), expectedEmailWarning);
        Assert.assertEquals(registerPage.getTelePhoneWarning(), expectedTelephoneWarning);

    }
    @Test(priority = 17, dataProvider="passwordSupplier")
    public void verifyRegisteringAccountUsingPasswordsWhichAreNotFollowingPasswordComplexityStandards(String passwordText) {


        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();

        String expectedWarning = "Enter password which follows Password Complexity Standard!";

        // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedWarning);
    }

    @DataProvider(name="passwordSupplier")
    public Object[][] supplyPasswords() {

        Object[][] data = {{"12345"},{"abcdefghi"},{"abcd1234"},{"abcd123$"},{"ABCD456#"}};
        return data;

    }
    @Test(priority = 19)
    public void verifyLeadingAndTrailingSpacesWhileRegisteringAccount(){

        String enteredFirstName= "   " + prop.getProperty("firstName")+ "  ";
        registerPage.enterFirstName(enteredFirstName);
        String enteredLastName = "   " + prop.getProperty("lastName")+ "  ";
        registerPage.enterLastName(enteredLastName);
        String enteredEmail = "   "+ CommonUtilities.generateBrandNewEmail();
        registerPage.enterEmailId(enteredEmail);
        String enteredTelephone = "   " + prop.getProperty("telephoneNumber")+ "  ";
        registerPage.enterTelephoneNumber(enteredTelephone);
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();

        registerPage.setEditAccountbutton();
        Assert.assertEquals(registerPage.getFirstNameFieldValue(), enteredFirstName.trim());
        Assert.assertEquals(registerPage.getLastNameFieldValue(), enteredLastName.trim());
        Assert.assertEquals(registerPage.getEmailFieldValue(), enteredEmail);
        Assert.assertEquals(registerPage.getTelephoneFieldValue(), enteredTelephone);
    }
    @Test(priority = 20, enabled = false)
    public void verifyPrivacyPolicyFieldOnRegisterAccountPage() {

        Assert.assertFalse(registerPage.isPrivacypolicySelected());

    }
    @Test(priority = 21, enabled = false)
    public void verifyRegisterAccountWithoutPrivacyPolicy(){

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();

        String expectedWarning = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedWarning);

    }
    @Test(priority = 22)
    public void verifyVisiilityTogglingofPasswordFieldOnRegisterAccount(){
        Assert.assertEquals(registerPage.getPasswordFieldValue(), "password");
        Assert.assertEquals(registerPage.getPasswordConfirmValue(), "password");

    }

    @Test(priority = 24)
    public void verifyRegisteringAccountWithoutEnteringPasswordConfirmField(){

        registerPage.enterFirstName(prop.getProperty("firstName"));
        registerPage.enterLastName(prop.getProperty("lastName"));
        registerPage.enterEmailId(CommonUtilities.generateBrandNewEmail());
        registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
        registerPage.enterPasswordFiled(prop.getProperty("validPassword"));
        registerPage.enterPasswordConfirmField(prop.getProperty("validPassword"));
        registerPage.selectYesNewletterOption();
        registerPage.selectPrivacyPolicyFiled();
        accountSuccesspage = registerPage.clickOnContinueButton();

        String expectedWarningMessage = "Password confirmation does not match password!";
        Assert.assertEquals(registerPage.getPasswordConfirmWarning(), expectedWarningMessage);

    }
    @Test(priority = 25)
    public void verifyRegisterPageBreadCrumbAndHeadingTitles(){


        Assert.assertTrue(registerPage.didWeNavigateToRegisterAccountPage());

        String expectedHeading = "Register Account";
        Assert.assertEquals(registerPage.getRegisterPageHeading(), expectedHeading);

        String expectedURl = "https://tutorialsninja.com/demo/index.php?route=account/register";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);

        String expectedTitle = "Register Account";
        Assert.assertEquals(driver.getTitle() , expectedTitle);
    }

}


