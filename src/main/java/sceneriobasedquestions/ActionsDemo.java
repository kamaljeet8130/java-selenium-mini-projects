package sceneriobasedquestions;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.stepcampus.in/playground");
        WebElement hoverButton = driver.findElement(By.xpath("//button[@data-state=\"closed\" and text()=\"Hover over me\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
    }
}
////button[@data-state="closed" and text()="Hover over me"]