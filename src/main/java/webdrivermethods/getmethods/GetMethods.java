package webdrivermethods.getmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        String windowId = driver.getWindowHandle();
        System.out.println("windowId: " + windowId);
        WebElement link = driver.findElement(By.linkText("OrangeHRM, Inc"));
        link.click();
      driver.quit();

    }
}
// get method work on web pages not on web element
