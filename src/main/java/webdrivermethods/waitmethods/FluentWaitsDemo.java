package webdrivermethods.waitmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> myWaits = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement usrTxt=myWaits.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
            }
        });
        usrTxt.sendKeys("Admin");
    }
}
