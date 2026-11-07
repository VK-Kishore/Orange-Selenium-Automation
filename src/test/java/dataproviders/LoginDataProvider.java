//package dataproviders;
//
//import org.testng.annotations.DataProvider;
//
//public class LoginDataProvider {
//    @DataProvider(name = "loginData")
//    public static Object[][] getData() {
//
//        return new Object[][] {
//
//                {"Admin", "admin123", true},
//
//                {"Admin", "wrong123", false},
//
//                {"Tester", "test123", false}
//
//        };
//    }
//}

package dataproviders;

import Utilities.ExcelUtility;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getData() {

        return ExcelUtility.getLoginData();
    }
}