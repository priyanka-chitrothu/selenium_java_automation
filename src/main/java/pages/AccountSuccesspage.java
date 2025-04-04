package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesspage {
    WebDriver driver;

    public AccountSuccesspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
    private WebElement logoutOption;

   @FindBy(xpath = "//div[@id = 'common-success']//h1")
   private WebElement pageHeading;

    @FindBy(id = "content")
    private WebElement pageContent;

    @FindBy(linkText = "Continue")
    private WebElement continueButton;

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Success']")
    private WebElement accountSuccessPageBreadCrumb;

    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    private WebElement subscribeOrUnSubscribeNewsletterOption;


    public boolean isUserLoggedIn(){
        return logoutOption.isDisplayed();
    }

    public String getPageHeading(){
       return pageHeading.getText();
    }

    public String getPageContent(){
        return pageContent.getText();
    }

    public AccountPage clickOnContinueButton(){
        continueButton.click();
        return new AccountPage(driver);
    }

    public boolean didWeNavigateToAccountSuccessPage(){
       return accountSuccessPageBreadCrumb.isDisplayed();
    }

    public NewsLetterPage selectSubscribeUnsubscribeOption(){
        subscribeOrUnSubscribeNewsletterOption.click();
        return new NewsLetterPage(driver);
    }
}

