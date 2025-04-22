package SeleniumInterviewQuestions;

import base.Base;
import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Highlighter;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverBasicCommands extends Base {

        WebDriver driver;
        @BeforeMethod
        public void setup() {
            driver = openBrowserApplication();
        }
        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
        @Test(priority = 1, enabled = false)
            public void VerifyBasicWebDriverCommands() {
            String title = driver.getTitle();
            System.out.println(title);

            String CurrentURl = driver.getCurrentUrl();
            System.out.println(CurrentURl);

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String domain = (String) jsExecutor.executeScript("return document.domain");
            System.out.println("Domain using JS: " + domain);

            if(driver.findElement(By.xpath("//textarea[@name = 'q']")).isEnabled()){
                System.out.println("Google search box is enabled");
                driver.findElement(By.xpath("//textarea[@name = 'q']")).sendKeys("Monarch Tractor");
                driver.findElement(By.xpath("(//div[@class='sbic sb43'])[1]")).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

                WebElement link = driver.findElement(By.xpath("//h3[contains(text(), \"Monarch Tractor: World's First Electric Autonomous Tractor\")]"));
                Actions newTab = new Actions(driver);
                newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(link).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
            }


            }
       @Test(priority = 2, enabled = false)
        public void VerifyNavigatingBackAndForward() throws InterruptedException{
            driver.navigate().to("https://www.amazon.in/");
            driver.navigate().back();
            driver.navigate().forward();

        }
        @Test(priority = 3, enabled = false)
        public void VerifyCaptureScreenShot() throws InterruptedException,IOException {
            File ScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(ScreenShot, new File("C:\\workspace\\selenium_java_automation\\ScreenShots\\));
            File destFile = new File("C:\\workspace\\selenium_java_automation\\ScreenShots\\screenshot_" +ScreenShot.getName());
            FileUtils.copyFile(ScreenShot, destFile);
        }
        @Test(priority = 4, enabled = false)
        public void VerifyHandlingJavaScriptAlertsAndConfirmationPrompts() throws InterruptedException{
            driver.findElement(By.xpath("//input[@value=\"Show Me Alert\"]")).click();
            Alert A1 = driver.switchTo().alert();

            String Alert1 = A1.getText();
            System.out.println(Alert1);
            Thread.sleep(2000);
            A1.accept();

            driver.findElement(By.xpath("//button[normalize-space()= 'Show Me Confirmation']")).click();
            Alert A2 = driver.switchTo().alert();
            String Alert2 = A2.getText();
            System.out.println(Alert2);
            A2.dismiss();

            driver.findElement(By.xpath("//button[normalize-space ()= 'Show Me Prompt']")).click();
            Alert A3 = driver.switchTo().alert();
            String Alert3 = A3.getText();
            System.out.println(Alert3);
            A3.sendKeys("this is priyanka");
            A3.accept();
        }

        @Test(priority = 5, enabled = false)
        public void VerifyHighlightingElementInSeleniumWebDriverHandlingUnexpectedAlert() throws InterruptedException{
            try{
                driver.switchTo().alert().dismiss();
            }catch (Exception e){
                System.out.println("unexpected alert not present");
            }

        }
        @Test(priority = 6, enabled = false)
        public void VerifyReadingFontPropertiesInSeleniumWebDriver() throws InterruptedException{
            WebElement text = driver.findElement(By.xpath("//a[normalize-space()= 'Only Testing']"));
             String fontSize = text.getCssValue("font-size");
             System.out.println(fontSize);

             String fontColor = text.getCssValue("color");
             System.out.println(fontColor);

             String fontFamily = text.getCssValue("font-family");
             System.out.println(fontFamily);

             String fonttxtAlign = text.getCssValue("txt-align");
             System.out.println(fonttxtAlign);
        }
        @Test(priority = 7)
        public void VerifyGeneratingMouseHoverEventOnMainMenuToClickonSubMenu() throws InterruptedException{
            Actions actions = new Actions(driver);
            WebElement moveonmenu = driver.findElement(By.xpath("//div[@id = 'menu1']/div"));
            actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.titleContains("Google"));
        }
        @Test(priority = 8, enabled = false)
        public void VerifyPageScrollDifferentWaysUsingSeleniumWebDriver() throws InterruptedException{
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down to the bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            System.out.println("Scrolled to bottom");
            Thread.sleep(2000);

            // Scroll up to the top
            js.executeScript("window.scrollTo(0, 0);");
            System.out.println("Scrolled to top");
            Thread.sleep(2000);

            // Auto scroll (smooth scroll using interval)
            String autoScrollScript =
                    "let scrollInterval = setInterval(() => {" +
                            "  window.scrollBy(0, 50);" +
                            "  if ((window.innerHeight + window.scrollY) >= document.body.scrollHeight) {" +
                            "    clearInterval(scrollInterval);" +
                            "  }" +
                            "}, 100);";
            js.executeScript(autoScrollScript);
            System.out.println("Auto scrolling...");
        }
        @Test(priority = 9, enabled = false)
        public void VerifyExtractingALlLinksFromPage() throws InterruptedException{

              List<WebElement> noLinks = driver.findElements(By.tagName("a"));
              System.out.println("Total links:"+ noLinks.size());
              for(WebElement el : noLinks){
                  String linkText= el.getText();
                  String href = el.getAttribute("href");
                  if(href!= null && href.isEmpty()){
                      System.out.println("link Text"+ linkText + "href"+ href);
                  }

              }
        }



}

