package interactions.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InteractWithAlertUsingExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait  =new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement alertBtn = driver.findElement(By.cssSelector("button#confirmBtn"));
        alertBtn.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
