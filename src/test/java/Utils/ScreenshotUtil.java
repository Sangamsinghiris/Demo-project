package Utils;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";

        String path = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Create destination file
            File destination = new File(path);
            destination.getParentFile().mkdirs(); // create folder if not exists

            // Copy file
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved: " + path);

        } catch (IOException e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }

        return path;
    }
}