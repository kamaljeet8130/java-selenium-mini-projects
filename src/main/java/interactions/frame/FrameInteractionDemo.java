package interactions.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameInteractionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Hello world");
        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//form/div/input[@name=\"mytext2\"]")).sendKeys("world hello");
        driver.switchTo().defaultContent();
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
        driver.switchTo().frame(frame3);
        WebElement frame3InputBox = driver.findElement(By.xpath("//input[@name=\"mytext3\"]"));
        frame3InputBox.sendKeys("java");

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id=\"i9\"]")).click();


    }
}
