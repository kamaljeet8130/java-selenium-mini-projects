package webdrivermethods.navigationalmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement linkToClick =myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p/a[text()=\"OrangeHRM, Inc\"]")));
        linkToClick.click();
        Set<String> windowId = driver.getWindowHandles();

        // Approach 1
       /* System.out.println("title before switching window : "+ driver.getTitle());
        ArrayList<String> windowList = new ArrayList<>(windowId);
        String parentId = windowList.get(0);
        String childId = windowList.get(1);
        driver.switchTo().window(childId);
        System.out.println("Title after Switching window: " + driver.getTitle());
        driver.quit();*/

        //Approach 2
        for(String winId: windowId){

            String title = driver.switchTo().window(winId).getTitle();
            if(title.equals("OrangeHRM")){
                driver.close();
            }
        }
    }
}
