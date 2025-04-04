package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  @FindBy(id = "input-firstname")
  private WebElement firstnameField;

  @FindBy(id = "input-lastname")
  private WebElement lastNameField;

  @FindBy(id = "input-email")
  private WebElement emailField;

  @FindBy(id = "input-telephone")
  private WebElement telephoneFiled;

  @FindBy(id = "input-password")
  private WebElement passwordFiled;

  @FindBy(id = "input-confirm")
  private WebElement passwordConfirmField;

  @FindBy(name = "agree")
  private WebElement privacyPolicyField;

  @FindBy(xpath = "//input[@class = 'btn btn-primary']")
  private WebElement continueButtonField;

  @FindBy(xpath = "//input[@name = 'newsletter'][@value = '1']")
  private WebElement yesNewsletterOption;

  @FindBy(xpath = "//input[@id = 'input-firstname']/following-sibling::div")
  private WebElement firstNameWarning;

  @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
  private WebElement lastNameWarning;

  @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
  private WebElement emailIDWarning;

  @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
  private WebElement telePhoneWarning;

  @FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
  private  WebElement passwordWarning;

  @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
  private WebElement privacyPolicyWarning;

  @FindBy(xpath = "//ul[@class ='breadcrumb']//a[text() = 'Register']")
  private WebElement registerBreadCrumb;

  @FindBy(xpath = "//span[text()='My Account']")
  private WebElement myAccountDropdown;

  @FindBy(linkText = "Login")
  private WebElement loginOption;

  @FindBy(xpath = "//div[@class= 'text-danger']")
  private WebElement passwordConfirmWarning;

  @FindBy(xpath = "//div[@class= 'text-danger'][text() = 'E-Mail Address does not appear to be valid!']")
  private WebElement alreadyExistEmailWarning;

  @FindBy(css = "label[for = 'input-firstname']")
  private WebElement firstNamelabel;

  @FindBy(css = "label[for ='input-lastname']")
  private WebElement LastNamelabel;

  @FindBy(linkText = "Edit your account information")
  private WebElement editAccountbutton;

  @FindBy(xpath = "//input[@name ='agree'][@value =1]")
  private WebElement privacyPolicySelect;

  @FindBy(xpath = "//a/i[@class= 'fa fa-heart']")
  private WebElement rightSideLoginButton;

  @FindBy(xpath = "//a/i[@class= 'fa fa-phone")
  private WebElement contactUsButton;

  @FindBy(xpath = "//div[@id= 'content']/h1")
  private WebElement registerPageHeading;

    public void enterFirstName(String firstNameText){
      firstnameField.sendKeys(firstNameText);
    }

    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void enterEmailId(String emailAddress){
        emailField.sendKeys(emailAddress);
    }

    public void enterTelephoneNumber(String telephoneNumber){
      telephoneFiled.sendKeys(telephoneNumber);
    }

    public void enterPasswordFiled(String passwordText){
      passwordFiled.sendKeys(passwordText);
    }

    public void enterPasswordConfirmField(String passwordConfirmText){
      passwordConfirmField.sendKeys(passwordConfirmText);
    }

    public void selectPrivacyPolicyFiled(){
      privacyPolicyField.click();
    }


    public AccountSuccesspage clickOnContinueButton(){
        continueButtonField.click();
        return new AccountSuccesspage(driver);
    }

    public void selectYesNewletterOption(){
      yesNewsletterOption.click();
    }

    public String getFirstNameWarning(){
      return firstNameWarning.getText();
    }

    public String getLastNameWarning(){
      return  lastNameWarning.getText();
    }

    public String getEmailWarning(){
      return  emailIDWarning.getText();
    }

    public String getTelePhoneWarning(){
      return  telePhoneWarning.getText();
    }

    public String getPasswordWarning(){
      return  passwordWarning.getText();
    }

    public String getPrivacyPolicyWarning(){
      return  privacyPolicyWarning.getText();
    }

    public boolean didWeNavigateToRegisterAccountPage(){
      return  registerBreadCrumb.isDisplayed();
    }
     public void clickOnMyAccount(){
      myAccountDropdown.click();
     }
     public LoginPage selectLoginOption(){
      loginOption.click();
      return new LoginPage(driver);
     }

     public String getPasswordConfirmWarning(){
      return passwordConfirmWarning.getText();
     }

     public String getAlreadyExistEmailWarning(){
      return alreadyExistEmailWarning.getText();
     }

     public String getEmailValidationMessage(){
       return emailField.getDomProperty("validationMessage");
     }

     public void clearEmailField(){
      emailField.clear();
     }

     public String firstNamePlaceholder(){
        return firstnameField.getDomProperty("placeholder");
     }

     public String lastNamePlaceholder(){
        return lastNameField.getDomProperty("placeholder");
     }

     public String emailIdPlaceholder(){
        return emailField.getDomProperty("placeholder");
     }

     public String telephonePlaceholder(){
        return telephoneFiled.getDomProperty("placeholder");
     }

     public String passwordPlaceholder(){
        return passwordFiled.getDomProperty("placeholder");
     }

     public String passwordConfirmPlaceholder(){
        return passwordConfirmField.getDomProperty("placeholder");
     }
     public String getFirstNameContent(WebDriver driver){
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         String fnContent =(String)jse.executeScript( "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNamelabel);
         return fnContent;
     }
     public String getFirstNameLabelColor(WebDriver driver){
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         String fnColor =(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstNamelabel);
         return fnColor;

     }
    public String getLastNameContent(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String fnContent =(String)jse.executeScript( "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", LastNamelabel);
        return fnContent;
    }
    public String getLastNameLabelColor(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String fnColor =(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", LastNamelabel);
        return fnColor;

    }

    public String getFirstNameFieldValue(){
        return firstnameField.getDomProperty("value");
    }
    public String getLastNameFieldValue(){
        return lastNameField.getDomProperty("value");
    }
    public String getTelephoneFieldValue(){
        return telephoneFiled.getDomProperty("value");
    }
    public String getEmailFieldValue(){
        return emailField.getDomProperty("value");
    }
    public String getPasswordFieldValue(){
        return passwordFiled.getDomProperty("value");
    }
    public void setEditAccountbutton(){
        editAccountbutton.click();
    }
    public boolean isPrivacypolicySelected(){
        return privacyPolicySelect.isSelected();
    }
    public String getPasswordValue(){
        return passwordFiled.getDomProperty("type");
    }
    public String getPasswordConfirmValue(){
        return passwordConfirmField.getDomProperty("type");
    }
    public LoginPage clickOnRightSideLogin(){
        rightSideLoginButton.click();
        return new LoginPage(driver);
    }
    public void clickOnContactUsButton(){
        contactUsButton.click();
    }
    public boolean getRegisterPageHeading(){
         registerPageHeading.isDisplayed();
    }


}
