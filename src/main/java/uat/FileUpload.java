package uat;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilis.CommonUtilities;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;


public class FileUpload extends Base {
    WebDriver driver;
    Properties prop;
    @BeforeMethod
    public void setUp(){
        driver = openBrowserApplication();
        prop = CommonUtilities.loadProperties();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }
    @AfterMethod
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void exampleFileUploadScript(){
        WebElement uploadButton = driver.findElement(By.xpath("//input[@class= 'upload-button'"));
        uploadButton.sendKeys("C:\\\\Users\\\\User\\\\Desktop\\\\sample.pdf");
        System.out.println("file uploaded successfully");
    }
    @Test(priority = 2)
    public void exampleFileuploadUsingRobotClass() throws InterruptedException, AWTException {
        WebElement uploadButton = driver.findElement(By.xpath("//input[@class= 'upload-button'"));
        uploadButton.click();
        Robot robot = new Robot();

        // Copy file path to clipboard
        StringSelection selection = new StringSelection("C:\\Users\\User\\Desktop\\sample.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Paste and press Enter
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000); // Wait for paste action
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File uploaded successfully!");
    }



}
