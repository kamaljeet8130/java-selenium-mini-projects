package interactions.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectDropdownInteractionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement countryDropdown = driver.findElement(By.cssSelector("select#country"));
        Select dropdown = new Select(countryDropdown);
        WebElement firstSelectedDropDown = dropdown.getFirstSelectedOption();
        System.out.println(firstSelectedDropDown.getText());
        dropdown.selectByVisibleText("France");
        System.out.println(firstSelectedDropDown.getText());

        List<WebElement> countryList = dropdown.getOptions();
        System.out.println(countryList.size());
        for(WebElement country : countryList){
            System.out.println(country.getText());
        }


    }
}
