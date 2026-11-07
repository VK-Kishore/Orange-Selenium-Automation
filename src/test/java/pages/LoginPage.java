package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name="password")
    private WebElement passWord;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginbutton;
    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorMessage;

    public void userNameField(String name){
        username.sendKeys(name);

    }
    public void passWordNameField(String password){
        passWord.sendKeys(password);

    }
    public String getErrorMessage() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(5));   ///error ,message
        return wait.until(
                ExpectedConditions.visibilityOf(errorMessage)
        ).getText();
    }

    public void login(){
        loginbutton.click();
    }
    public void logingIn(String name,String password){
        userNameField(name);
        passWordNameField(password);
        login();


    }

}
