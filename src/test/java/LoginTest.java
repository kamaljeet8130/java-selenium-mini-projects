import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void validUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "Password123");
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title Validation Failed");
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(header.getText(), "Logged In Successfully", "Header Validation Failed");
        WebElement logoutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutBtn.isDisplayed(), "Log out button not visible");
    }

    @Test
    public void testLogin_WithValidCredentials_ShouldDisplaySuccessMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "Password123");
        WebElement header = driver.findElement(By.tagName("h1"));
        String headerText = header.getText();
        Assert.assertEquals(headerText, "Logged In Successfully", "header validation Failed");
    }

    @Test
      public void testLogin_WithInvalidUsername_ShouldShowUsernameError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("dfs", "Password123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!", "username error message failed");
    }

    @Test
      public void testLogin_WithInvalidPassword_ShouldShowPasswordError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "adfdf");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!", "password error message failed");
    }

    @Test
      public void testLogin_WithInvalidUsernameAndPassword_ShouldPrioritizeUsernameError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("adfd", "afsdf");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!", "username error message failed");
    }

    @Test
      public void testLogin_WithEmptyUsername_ShouldShowUsernameError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("", "Password123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!", "username error message failed");
    }

    @Test
      public void testLogin_WithEmptyPassword_ShouldShowPasswordError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!", "password error message failed");
    }

    @Test
      public void testLogin_WithEmptyFields_ShouldShowUsernameErrorFirst() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!", "username error message failed");
    }

    @Test
      public void testLogin_WithSpecialCharactersInUsername_ShouldRejectLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("#@$#$", "Password");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!", "username error message failed");
    }

    @Test
      public void testLogin_WithSpecialCharactersInPassword_ShouldRejectLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "#32Passwrod");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error"))
        );
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!", "password error message failed");
    }

    @Test
      public void testBackNavigation_AfterLogout_ShouldNotAllowSecureAccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "Password123");
        WebElement logoutBtn = driver.findElement(By.xpath("//div/a[text()=\"Log out\"]"));
        Assert.assertTrue(logoutBtn.isDisplayed());
        Assert.assertTrue(logoutBtn.isEnabled());
        logoutBtn.click();
        System.out.println(driver.getCurrentUrl() + "\n " +
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

    @Test
      public void testBackNavigation_WhileLoggedIn_ShouldStayInSecureArea() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("student", "Password123");
        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(header.getText(), "Logged In Successfully", "Header Validation Failed");
        System.out.println(driver.getCurrentUrl() + "\n " +
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
}


