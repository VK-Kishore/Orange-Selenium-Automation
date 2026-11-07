package Utilities;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.*;

public class ScreenshotUtility {

    public static String captureScreenshot(
            WebDriver driver, String testName) {

        try {
            String folder = System.getProperty("user.dir")
                    + "/screenshots/";

            Files.createDirectories(Paths.get(folder));  ///Create folder

            String path = folder + testName + "_"
                    + System.currentTimeMillis() + ".png";  ///save with time

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);   ////Take screenshot

            Files.copy(source.toPath(), Paths.get(path));  ///Save screenshot

            return path;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
