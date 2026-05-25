package Base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import Utils.ConfigReader;
import Utils.ExtentManager;

public class BaseTest {

    public static WebDriver driver;

public static ExtentReports extent;
    public static ExtentTest test;
    public static Logger log = LogManager.getLogger(BaseTest.class);


    @BeforeClass
    public void setup() {
    	

    	 extent = ExtentManager.getInstance();

    	        log.info("Launching browser");
    	        WebDriverManager.chromedriver().setup();
    	        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }
    

@AfterMethod
    public void tearDownMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
            log.info("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed");
            log.error("Test Failed");
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();

        extent.flush();

               log.info("Browser closed & report generated");

    }
}