package Utils;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Sangam");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}

