package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();////1.ThreadLocal driver
    public static WebDriver createsDriver(String browser) {

        switch (browser.toLowerCase()) {    ///2.browser
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException(
                        "Unsupported browser:" + browser
                );

        }
    }
    // 3. Store driver for current thread thread concepts
    public static void setDriver(String browser) {
        driver.set(createsDriver(browser));
    }

    // 4. Get driver for current thread thread concepts
    public static WebDriver getDriver() {
        return driver.get();
    }

    // 5. Close browser and remove driver  thread concepts
    public static void quitDriver() {
        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}




