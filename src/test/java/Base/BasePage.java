package Base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;

import Utils.WaitUtils;
import Utils.ConfigReader;
import Utils.ExtentManager;
import Utils.ScreenshotUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;
    protected ExtentReports extent;
    protected ExtentTest test;

    protected static Logger log = LogManager.getLogger(BasePage.class);

    // ✅ Setup
    @BeforeClass
    public void setup() {

        try {
            String url = ConfigReader.get("url");

            log.info("Launching Chrome Browser");

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);   

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);

            wait = new WaitUtils(driver);
            extent = ExtentManager.getInstance();

            log.info("URL opened: {}", url);

        } catch (Exception e) {

            log.error("Setup failed", e);

            if (driver != null) {
                ScreenshotUtil.takeScreenshot(driver, "SetupFailure");
            }

            throw e;
        }
    }

    // ✅ Auto Screenshot + Report Handling
    @AfterMethod
    public void afterMethod(ITestResult result) {

        if (driver == null) {
            return; // avoid null pointer
        }

        String testName = result.getName();

       // test = extent.createTest(testName);

        if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("✅ Test Passed");
            log.info("Test Passed: {}", testName);

        } else if (result.getStatus() == ITestResult.FAILURE) {

            String path = ScreenshotUtil.takeScreenshot(driver, testName);

            test.fail("❌ Test Failed")
                .addScreenCaptureFromPath(path);

            log.error("Test Failed: {}", testName);

        } else if (result.getStatus() == ITestResult.SKIP) {

            test.skip("⚠️ Test Skipped");
            log.warn("Test Skipped: {}", testName);
        }
    }

    // ✅ Teardown
    @AfterClass
    public void teardown() {

        log.info("Closing browser...");

        if (driver != null) {
            driver.quit();
        }

        if (extent != null) {
            extent.flush();
        }

        log.info("Browser closed successfully");
    }
}
