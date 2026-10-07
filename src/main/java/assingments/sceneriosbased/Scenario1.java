package assingments.sceneriosbased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scenario1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");

        WebElement selectListFromPort = driver.findElement(By.xpath("//select[@name=\"fromPort\" and @class=\"form-inline\"]"));
        Select dropdown = new Select(selectListFromPort);
        dropdown.selectByVisibleText("Philadelphia");

        WebElement selectListToPort = driver.findElement(By.xpath("//select[@name=\"toPort\" and @class=\"form-inline\"]"));
        new Select(selectListToPort).selectByVisibleText("Berlin");

        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        List<WebElement> priceList = driver.findElements(By.xpath("//table//td[6]"));

        float lowestValue = Integer.MAX_VALUE;
        WebElement lowestPriceElent = null;
        for (WebElement price : priceList) {
            String removeSymmbol = price.getText().replace("$", "");
            float currentValue = Float.parseFloat(removeSymmbol);
            if (currentValue < lowestValue) {
                lowestValue = currentValue;
                lowestPriceElent = price;
            }

        }
        lowestPriceElent.findElement(
                By.xpath("./preceding-sibling::td[5]")
        ).click();

        System.out.println(driver.findElement(By.tagName("h2")).
                getText());

        driver.quit();
    }

}
