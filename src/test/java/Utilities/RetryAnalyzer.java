package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {////TestNG interface for retry logic

    int count = 0;  ////Tracks retry attempts
    int maxRetry = 2;  ///Maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetry) {
            count++;
            System.out.println("Retrying: " + result.getName());
            return true;
        }

        return false;
    }
}