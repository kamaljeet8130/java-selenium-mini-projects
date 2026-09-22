package webdrivermethods.waitmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ExplicitWaitsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWaits = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement txtUserName = myWaits.until(
                ExpectedConditions.
                        visibilityOfElementLocated(
                By.xpath("//input[@placeholder=\"Username\"]")));
        txtUserName.sendKeys("Admin");
        WebElement txtPassword = myWaits.until(
                ExpectedConditions.
                        visibilityOfElementLocated(
                                By.xpath("//input[@placeholder=\"Password\"]")
                        )
        );
        txtPassword.sendKeys("admin123");

        WebElement loginButton = myWaits.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\" Login \"]")));
        loginButton.click();
        WebElement dashboardText = myWaits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/h6[text()=\"Dashboard\"]")));
        boolean isTextDisplayed = dashboardText.isDisplayed();
        Assert.assertTrue(isTextDisplayed);
        driver.quit();
    }
}
/*
explicit wait :
first declaration and then use
Declared by WebDriverWaits class with having constructor which require 2 args , driver and time

.. it is conditional based it work more effectively
finding element is inclusive as it is generic type
it will wait for condition to be true , and the consider time
we need to write multiple statement for multiple elements
 */