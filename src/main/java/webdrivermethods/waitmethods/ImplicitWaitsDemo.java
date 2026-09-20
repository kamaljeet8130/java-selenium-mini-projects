package webdrivermethods.waitmethods;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement userNameInputBox = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        userNameInputBox.sendKeys("Admin");
    }
}
/*
Implicit Wait:

Once defined, it applies to all elements for the entire lifecycle of the WebDriver instance
if the element is found before the timeout expire. the script moves to the next line immediately( it does not wait for the maximum duration)
if the element is still missing after the timeout, it throws a NoSuchElementException

 */