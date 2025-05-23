package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary'][text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//aside[@id='column-right']//a[text()='Register']")
    private WebElement registerOption;

    @FindBy(xpath = "//ul[@class= 'breadcrumb']//a[text() = 'Login']")
    private WebElement navigateToLoginPage;

    @FindBy(id = "input-email")
    private WebElement emailText;

    @FindBy(id = "input-password")
    private WebElement passwordText;

    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    private WebElement loginButton;

    public void enterEmailText(String email){
        emailText.sendKeys(email);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnRegisterOption(){
        registerOption.click();
    }

    public void enterPasswordText(String password){
        passwordText.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

}
