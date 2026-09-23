package interactions.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PromptAlertInteractionDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement alertBtn = driver.findElement(By.cssSelector("button#promptBtn"));
        alertBtn.click();
        Alert myAlert = driver.switchTo().alert();
        myAlert.sendKeys("hello world");
        Thread.sleep(5000);
        myAlert.accept();
    }
}
