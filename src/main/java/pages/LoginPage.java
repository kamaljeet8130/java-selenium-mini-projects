package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    static By userNameLocator = By.cssSelector("input#username");
    static By passwordLocator = By.cssSelector("input#password");
    static By submitButtonLocator = By.cssSelector("button#submit");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void openLoginPage(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    public void enterUserName(String user){
        driver.findElement(userNameLocator).sendKeys(user);
    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(submitButtonLocator).click();
    }
    public void login(String user, String password){
        enterUserName(user);
        enterPassword(password);
        clickLogin();
    }
}
