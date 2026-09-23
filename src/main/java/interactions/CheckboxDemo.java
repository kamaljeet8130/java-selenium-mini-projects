package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckboxDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

//        driver.findElement(By.xpath("//input[@type=\"checkbox\" and @id=\"sunday\"]")).click();
        List<WebElement> days = driver.
                findElements(
                        By.xpath(
                                "//input[@class=\"form-check-input\" and @type=\"checkbox\"]"
                        ));
        for(WebElement day: days){
            day.click();
        }

        // select last 3 checkbox
//        for(int i = days.size()-3;i<days.size();i++){
//            days.get(i).click();
//        }
        //select first 3 checkbox
//        for(int i = 0;i<=2;i++){
//            days.get(i).click();
//        }
        Thread.sleep(5000);
        for(WebElement day:days){
            if(day.isSelected())
                day.click();
        }
    }
}
//
