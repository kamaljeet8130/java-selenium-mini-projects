package interactions.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ConfirmationAlertInteractionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement alertBtn = driver.findElement(By.cssSelector("button#confirmBtn"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // close alert using cancel button
        alert.accept(); // close alert using OK button


    }

}
