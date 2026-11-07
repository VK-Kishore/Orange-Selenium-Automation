package Test;

import Listerners.TestListener;
import Utilities.RetryAnalyzer;
import base.BaseClass;
import dataproviders.LoginDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

@Listeners(TestListener.class)
public class test extends BaseClass {
    private static final Logger log =
            LogManager.getLogger(test.class);  ////log4j2

    @Test(dataProvider = "loginData",
            dataProviderClass = LoginDataProvider.class,retryAnalyzer = RetryAnalyzer.class) ///retry analyzer
    public void loginTest(String username, String password, boolean expectedResult) {
        //LoginPage loginpage = new LoginPage(driver);
        LoginPage loginpage = new LoginPage(getDriver());///thread
        loginpage.logingIn(username, password);
        //String Browserheader = driver.getTitle();
        String Browserheader = getDriver().getTitle();///thread
        log.info("Browser title: {}", Browserheader);


        if (expectedResult) {
           // DashboardPage dashboardPage = new DashboardPage(driver);
            DashboardPage dashboardPage = new DashboardPage(getDriver());///thread
            Assert.assertEquals(
                    dashboardPage.getDashboardText(),    ////dashboard
                    "Dashboard");
            dashboardPage.logout();
            Assert.assertTrue(
                   // driver.getCurrentUrl().contains("/auth/login"
                    getDriver().getCurrentUrl().contains("/auth/login")///thread
                    );
        }
        else{
            Assert.assertEquals(
                    loginpage.getErrorMessage(),
                    "Invalid credentials"
            );
        }

    }

}
