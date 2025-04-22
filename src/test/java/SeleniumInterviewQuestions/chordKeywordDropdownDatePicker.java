package SeleniumInterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class chordKeywordDropdownDatePicker {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testKeys_Chord() throws Exception {
        driver.get("https://accounts.google.com/signup");
        WebElement txtFName = driver.findElement(By.id("firstName"));
        WebElement txtLName = driver.findElement(By.id("lastName"));
        txtFName.sendKeys("WebDriver");
        Actions actions = new Actions(driver);
        actions.sendKeys(txtFName, Keys.chord(Keys.CONTROL, "a")).perform();
        actions.sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();
        actions.sendKeys(txtLName, Keys.chord(Keys.CONTROL, "v")).perform();
        Thread.sleep(2000);
    }

    @Test
    public void VerifyDropdownList() {
        driver.get("https://accounts.google.com/signup");
        WebElement txtFName = driver.findElement(By.id("firstName"));
        WebElement txtLName = driver.findElement(By.id("lastName"));
        txtFName.sendKeys("abcd");
        txtLName.sendKeys("hahdvbhdbv");
        driver.findElement(By.xpath("//span[@class= 'VfPpkd-vQzf8d']")).click();
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id= 'month']"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> allOptions = dropdown.getOptions();
        Set<String> uniqueOptions = new HashSet<>();
        Set<String> duplicateOptions = new HashSet<>();

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
            String text = option.getText().trim();
            if (!uniqueOptions.add(text)) {
                duplicateOptions.add(text);
            }
        }

            if (duplicateOptions.isEmpty()) {
                System.out.println("✅ No duplicate values in the dropdown.");
            } else {
                System.out.println("⚠️ Duplicate values found in the dropdown:");
                for (String dup : duplicateOptions) {
                    System.out.println(" - " + dup);
                }
            }

        }
        @Test
        public void VerifySelectBirthdayData(){
            driver.get("https://accounts.google.com/signup");
            WebElement txtFName = driver.findElement(By.id("firstName"));
            WebElement txtLName = driver.findElement(By.id("lastName"));
            txtFName.sendKeys("abcd");
            txtLName.sendKeys("hahdvbhdbv");
            driver.findElement(By.xpath("//span[@class= 'VfPpkd-vQzf8d']")).click();
            WebElement dropdownElement = driver.findElement(By.xpath("//select[@id= 'month']"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue("November");
            WebElement Day = driver.findElement(By.xpath("//input[@id ='day']"));
            Day.sendKeys("06");
            WebElement Year = driver.findElement(By.xpath("//input[@id ='year']"));
            Year.sendKeys("1997");
            WebElement Gender =driver.findElement(By.xpath("//select[@id ='gender']"));
            Select select = new Select(Gender);
            select.selectByValue("Female");
            driver.findElement(By.xpath("//span[@class ='VfPpkd-vQzf8d']")).click();
        }

    }

