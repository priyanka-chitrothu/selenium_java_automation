package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterPage {
    WebDriver driver;

    public NewsLetterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Newsletter']")
    private WebElement newsletterBreadCrumb;

    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsLetterPage;

    @FindBy(xpath = "//input[@name='newsletter'][@value='0']")
    private WebElement noNewsLetterOption;

    public boolean didWeNavigateToBreadCrumbPage(){
       return newsletterBreadCrumb.isDisplayed();
    }

    public boolean yesNewletterOptionSelected(){
        return yesNewsLetterPage.isSelected();
    }

    public boolean noNewsletterOptionSelected(){
        return noNewsLetterOption.isSelected();
    }
}
