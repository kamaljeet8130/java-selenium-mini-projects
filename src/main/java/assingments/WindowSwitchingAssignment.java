package assingments;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WindowSwitchingAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("input#Wikipedia1_wikipedia-search-input"));
        searchBox.sendKeys("selenium");
        driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']/div[@id='wikipedia-search-result-link']"));
        System.out.println("size of result : " + searchResult.size());
        for(WebElement result : searchResult){
            result.click();
        }

        Set<String> windowIds = driver.getWindowHandles();
        for(String winId: windowIds) {
            driver.switchTo().window(winId);
            String title = driver.getTitle();

            if(title.equals("Selenium - Wikipedia") || title.equals("Selenium dioxide - Wikipedia") )
                driver.close();
        }
        for(String winId: windowIds){
            try{
                driver.switchTo().window(winId);
                System.out.println(driver.getTitle());
            }catch (Exception e){
                System.err.println("Error");
            }
        }
    }

}
//input#Wikipedia1_wikipedia-search-input
//div[@class='wikipedia-search-results']/div[@id='wikipedia-search-result-link']