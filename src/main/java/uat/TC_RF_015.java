package uat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilis.CommonUtilities;

public class TC_RF_015 {

    @Test
    public void verifyDataBaseTestingForRegisterAccount() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://localhost/opencart/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        String enteredFirstNameData = "Arun";
        driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstNameData);

        String enteredLastNameData = "Motoori";
        driver.findElement(By.id("input-lastname")).sendKeys(enteredLastNameData);

        String enteredEmailData = CommonUtilities.generateBrandNewEmail();
        driver.findElement(By.id("input-email")).sendKeys(enteredEmailData);

        String enteredPasswordData = "1234512345";
        driver.findElement(By.id("input-password")).sendKeys(enteredPasswordData);
        WebElement element = driver.findElement(By.name("agree"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500); // Optional - wait to ensure scroll completion
        element.click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());


        //Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

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

        // Database credentials
        String jdbcURL = "jdbc:mysql://localhost:3306/opencart_db";
        String dbUser = "root";
        String dbPassword = null;

        // SQL query
        String sqlQuery = "SELECT * FROM oc_customer";

        // JDBC objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        int newsletter = 0;

        try {
            // Step 1: Register JDBC driver (optional in newer versions)

            // Step 2: Open a connection
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Connected to the database!");

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute the query
            resultSet = statement.executeQuery(sqlQuery);

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                firstName = resultSet.getString("firstname"); // Replace with your column name
                lastName = resultSet.getString("lastname"); // Replace with your column name
                email = resultSet.getString("email");
                newsletter = resultSet.getInt("newsletter");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        Assert.assertEquals(firstName, enteredFirstNameData);
        Assert.assertEquals(lastName, enteredLastNameData);
        //Assert.assertEquals(email, enteredEmailData);
        System.out.println("email in :"+enteredEmailData + " db :"+email);
        //Assert.assertEquals(newsletter, 1);

        driver.quit();

    }

}