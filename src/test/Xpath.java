import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Xpath {
    public static  void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/text-box";
        driver.get(url);

        WebElement element  = driver.findElement(By.xpath("/html/body/div/header/a/img"));
        System.out.println(element.getDomAttribute("src"));

        List<WebElement> elements = driver.findElements(By.xpath("//ing"));
        for(WebElement element1 : elements){
            System.out.println(element1.getDomAttribute("src"));
        }

        driver.quit();
    }
}
