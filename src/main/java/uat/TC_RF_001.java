package uat;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {

@Test
public static void main(String[] args){

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.get("https://tutorialsninja.com/demo/");

    driver.findElement(By.xpath("//span[text()='My Account']")).click();
    driver.findElement(By.linkText("Register")).click();

    driver.findElement(By.id("input-firstname")).sendKeys("Arun");
    driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
    driver.findElement(By.id("input-email")).sendKeys(generateBrandNewEmail());
    driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
    driver.findElement(By.id("input-password")).sendKeys("12345");
    driver.findElement(By.id("input-confirm")).sendKeys("12345");
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();

    Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

    String properDetailsOne = "Your Account Has Been Created!";
    String properDetailsTwo = "Congratulations! Your new account has been successfully created!";
    String properDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
    String properDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
    String properDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

    Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsOne));
    Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsTwo));
    Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsThree));
    Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsFour));
    Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(properDetailsFive));

    driver.findElement(By.linkText("Continue")).click();

    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

    driver.quit();

}
public static String generateBrandNewEmail(){
    return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
}
}
