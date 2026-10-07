package interactions.dropdowns;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSearchDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//div/textarea[@id=\"ti6dpd\"]"));
        searchBox.sendKeys("selenium");

        List<WebElement> searchResult = driver.findElements(By.xpath("//div/ul[@role=\"listbox\"]/li"));
        for (WebElement result : searchResult){
            String text = result.getText();
            if(text.equals("selenium 30")){
                result.click();
            }
        }
    }
}
//