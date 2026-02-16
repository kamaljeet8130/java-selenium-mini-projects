import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

public class CheckBoxHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        WebElement selectCheckBox = driver.findElement(By.xpath("xpath"));
        boolean isSelected = selectCheckBox.isSelected();
        boolean isDisplayed = selectCheckBox.isDisplayed();
        if (isDisplayed && !isSelected ) {
            selectCheckBox.click();
        }
        Select select = new Select(selectCheckBox);
        System.out.println(select.isMultiple());
    }
}
