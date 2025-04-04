package uat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageScrollExample {
    @Test
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try{
            driver.get("https://www.gmail.com");
            JavascriptExecutor js = (JavascriptExecutor) driver;

            //Scroll by specific pixel
            js.executeScript("window.scrollBy(0, 500)");
            System.out.println("Page will scroll by 500 Pixels");

            //scroll to bottom of the page
            js.executeScript("window.scrollTo(0, document.body.Height)");
            System.out.println("Page will scroll to bottom of the page");

            //scroll to top of the page
            js.executeScript("window.scrollTo(0,0)");
            System.out.println("Page will sroll to top of the page");

            //Scroll  to specific element of the page
            WebElement element = driver.findElement(By.id("targetElementId"));
            js.executeScript("arguments[0].scrollToView[true];", element);
            System.out.println("Scroll to target element");


        }catch (Exception e){
            e.printStackTrace();

        }finally {
            driver.quit();
        }
    }
}
