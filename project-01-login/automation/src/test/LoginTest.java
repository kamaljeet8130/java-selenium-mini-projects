import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    static By userNameLocator = By.cssSelector("input#username");
    static By passwordLocator = By.cssSelector("input#password");
    static By submitButtonLocator = By.cssSelector("button#submit");
    static String url = "https://practicetestautomation.com/practice-test-login/";


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        validUserLogin(driver,"student","Password123");
        testLogin_WithValidCredentials_ShouldDisplaySuccessMessage(driver,"student","Password123");
        testLogin_WithInvalidUsername_ShouldShowUsernameError(driver,"dfdf","Password123");
        tearDown(driver);

    }
    private static void validUserLogin(WebDriver driver, String userName,String Password) throws InterruptedException {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),url,"URL Validation Failed : actual Url");
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(Password);
        driver.findElement(submitButtonLocator).click();
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Title Validation Failed" );
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(header.getText(),"Logged In Successfully","Header Validation Failed");
        WebElement logoutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutBtn.isDisplayed() ,"Log out button not visible");
        System.out.println("All validation passed ");
    }

    private  static void testLogin_WithValidCredentials_ShouldDisplaySuccessMessage(WebDriver driver,String userName , String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebElement header = driver.findElement(By.tagName("h1"));
        String headerText = header.getText();
        Assert.assertEquals(headerText,"Logged In Successfully","header validation Failed");
    }

    private static void testLogin_WithInvalidUsername_ShouldShowUsernameError(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        System.out.println( " error message :::: \n" +
                errorMessage.getText() );
    }
    public static void tearDown(WebDriver driver){
        driver.quit();
    }
}


