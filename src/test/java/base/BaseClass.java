package base;

import Driver.DriverFactory;
import Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {
   /// protected WebDriver driver; thread


    public void setup(String browser) {
//       driver = DriverFactory.createsDriver(browser);
//        driver.get(ConfigReader.getProperty("url"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ////thread
        DriverFactory.setDriver(browser);
        DriverFactory.getDriver().manage()
                .timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url")
        );
        DriverFactory.getDriver().manage().window().maximize();
    }

        @BeforeMethod
    @Parameters("browser")
    public void launchApplication(String browser){
        setup(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
        ///thread
        DriverFactory.quitDriver();
    }

    public WebDriver getDriver() {   ///Listeners
//        return driver;

        ///thread
        return DriverFactory.getDriver();
    }
}




