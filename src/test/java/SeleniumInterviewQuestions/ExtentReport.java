package SeleniumInterviewQuestions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReport {
    public static void main(String[] args){
        ExtentReports extentReports = new ExtentReports();
        //File file = new File("index.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\karth\\Documents");
        extentReports.attachReporter(sparkReporter);
        ExtentTest test = extentReports.createTest("Demo Test", "Launch Google and verify title");

        WebDriver driver = new ChromeDriver();
        test.info("launch Web Browser");

        driver.get("https://www.google.com");
        test.pass("navigate to browser");

        String title = driver.getTitle();
        if(title.equals("Chrome")){
            test.pass("Title matches the browser name:"+ "Pass");
        }else{
            test.fail("Title not natching");
        }

        driver.quit();
        test.info("closes the browser");
        extentReports.flush();


    }


}
