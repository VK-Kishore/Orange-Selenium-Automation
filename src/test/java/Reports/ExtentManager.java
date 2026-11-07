package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport.html"); ///Creates the HTML report file
            extent = new ExtentReports();         /// Manages test report entries
            extent.attachReporter(spark);        /// Connects the HTML reporter to ExtentReports
        }
        return extent;
    }
}