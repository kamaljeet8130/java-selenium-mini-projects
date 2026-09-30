package assingments;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwitchingAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        WebElement frame5 = driver.findElement(By.xpath(" //frame[@src=\"frame_5.html\"]"));
        driver.switchTo().frame(frame5);
        WebElement linkInsideFrame =driver.findElement(By.xpath("//center/a[@href=\"https://a9t9.com\"]"));
        linkInsideFrame.click();
        driver.switchTo().frame(0);
        WebElement logoImg = driver.findElement(By.xpath("//a[@id=\"logo\"]/img"));
        System.out.println(logoImg.getAttribute("src"));
        driver.switchTo().defaultContent();


    }
}
