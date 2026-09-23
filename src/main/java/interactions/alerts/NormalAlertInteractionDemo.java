package interactions.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NormalAlertInteractionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement alertBtn = driver.findElement(By.cssSelector("button#alertBtn"));
        alertBtn.click();
        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());
        myAlert.accept();
    }
}


/*
alert is not a webElemet we have interface Alert to
interact with alter having function in it like accept
dismiss ,sendKey() and all to perform various operation
 */