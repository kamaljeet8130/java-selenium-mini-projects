package webdrivermethods.waitmethods;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    }
}