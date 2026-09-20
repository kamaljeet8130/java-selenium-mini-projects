package webdrivermethods.waitmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleepWaitMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        WebElement userNameInputBox = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        userNameInputBox.sendKeys("Admin");
    }

}
/*
Thread.sleep() :
Advantage : Easy to use
DisAdvantages: if Time is not Sufficient you will get Exception NoSuchElement
it will wait for maximum time out. this will reduce the performance script
 */