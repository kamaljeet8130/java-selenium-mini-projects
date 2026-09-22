package webdrivermethods.navigationalmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationalMethodsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println(driver.getTitle());
       WebElement button =  driver.findElement(By.xpath("//div/ul/li/a[text()=\"PlaywrightPractice\"]"));
       button.click();
        System.out.println("title after clickng that button : " + driver.getTitle());
        System.out.println("url after clicking that button : " + driver.getCurrentUrl());
        System.out.println("Navigating back ");
        driver.navigate().back();
        System.out.println("now current current title after navigating back"+ driver.getTitle());
        System.out.println("now current url after navigating back : "+ driver.getCurrentUrl());
        driver.quit();

    }
}
