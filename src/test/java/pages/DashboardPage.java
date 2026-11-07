package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".oxd-userdropdown-name")
    private WebElement userProf;
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement dashLogout;
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashWelcome;

    public String getDashboardText(){
        return dashWelcome.getText();
    }
    public void logout() {
        this.userProf.click();
        this.dashLogout.click();

    }


}