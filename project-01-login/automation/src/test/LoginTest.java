import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        testLogin_WithInvalidPassword_ShouldShowPasswordError(driver,"student","dfjadr");
        testLogin_WithInvalidUsernameAndPassword_ShouldPrioritizeUsernameError(driver,"sdfdsf","Password123");
        testLogin_WithInvalidUsernameAndPassword_ShouldPrioritizeUsernameError(driver,"studedfnt","dfdsf");
        testLogin_WithEmptyUsername_ShouldShowUsernameError(driver,"","Password123");
        testLogin_WithEmptyPassword_ShouldShowPasswordError(driver,"student","");
        testLogin_WithEmptyFields_ShouldShowUsernameErrorFirst(driver,"","");
        testLogin_WithSpecialCharactersInUsername_ShouldRejectLogin(driver,"fdf343434!@#!#@!@","Password123");
        testLogin_WithSpecialCharactersInPassword_ShouldRejectLogin(driver,"student","534@#@!#!");
        testBackNavigation_AfterLogout_ShouldNotAllowSecureAccess(driver,"student","Password123");
        testBackNavigation_WhileLoggedIn_ShouldStayInSecureArea(driver,"student","Password123");
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
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your username is invalid!","username error message failed");
    }
    private static void testLogin_WithInvalidPassword_ShouldShowPasswordError(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your password is invalid!","password error message failed");
    }

    private static void testLogin_WithInvalidUsernameAndPassword_ShouldPrioritizeUsernameError(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your username is invalid!","username error message failed");
    }
    private static void testLogin_WithEmptyUsername_ShouldShowUsernameError(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your username is invalid!","username error message failed");
    }
    private static void testLogin_WithEmptyPassword_ShouldShowPasswordError(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your password is invalid!","password error message failed");
    }
    private static void testLogin_WithEmptyFields_ShouldShowUsernameErrorFirst(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your username is invalid!","username error message failed");
    }
    private static void testLogin_WithSpecialCharactersInUsername_ShouldRejectLogin(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your username is invalid!","username error message failed");
    }
    private static void testLogin_WithSpecialCharactersInPassword_ShouldRejectLogin(WebDriver driver,String userName ,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Your password is invalid!","password error message failed");
    }
    private static void testBackNavigation_AfterLogout_ShouldNotAllowSecureAccess(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebElement logoutBtn = driver.findElement(By.xpath("//div/a[text()=\"Log out\"]"));
        Assert.assertTrue(logoutBtn.isDisplayed());
        Assert.assertTrue(logoutBtn.isEnabled());
        logoutBtn.click();
        System.out.println(driver.getCurrentUrl()  + "\n " +
                "page url after logout");
        System.out.println(driver.getTitle() + "\n" +
                "page title after logout");
        driver.navigate().back();
        Assert.assertFalse(logoutBtn.isDisplayed());
        System.out.println(driver.getCurrentUrl() + "\n" +
                "page url after clicking browser back button");
        System.out.println(driver.getTitle() + "\n" +
                "page title after clicking browser back button");
    }
    private static void testBackNavigation_WhileLoggedIn_ShouldStayInSecureArea(WebDriver driver,String userName,String password){
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(header.getText(),"Logged In Successfully","Header Validation Failed");
        System.out.println(driver.getCurrentUrl()  + "\n " +
                "page url after logout");
        System.out.println(driver.getTitle() + "\n" +
                "page title after logout");
        driver.navigate().back();
        WebElement logoutBtn = driver.findElement(By.xpath("//div/a[text()=\"Log out\"]"));
        Assert.assertFalse(logoutBtn.isDisplayed());
        System.out.println(driver.getCurrentUrl() + "\n" +
                "page url after clicking browser back button");
        System.out.println(driver.getTitle() + "\n" +
                "page title after clicking browser back button");

    }
    public static void tearDown(WebDriver driver){
        driver.quit();
    }
}


