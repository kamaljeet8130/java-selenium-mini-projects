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

        float sum = 0;
        List<Float> prices = new ArrayList<>();
        for(WebElement price : priceList){
            String removeSymmbol = price.getText().replace("$","");
            float floatVal = Float.parseFloat(removeSymmbol);
            prices.add(floatVal);
        }
        Collections.sort(prices);
        float lowestPrice = prices.get(0);
        System.out.println(prices);
        String result = String.format("$%.2f",lowestPrice);
        System.out.println(result);

        for(WebElement price : priceList){
            if(price.getText().equals(result)){
                driver.findElement(
                        By.xpath("//table//td[6][text()='" + result + "']/preceding-sibling::td[5]")
                ).click();            }
        }
        System.out.println(driver.findElement(By.tagName("h2")).getText());

        driver.quit();

    }

}
