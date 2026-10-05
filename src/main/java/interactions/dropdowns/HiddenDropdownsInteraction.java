package interactions.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HiddenDropdownsInteraction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("**************");
        WebElement emailInputField = driver.findElement(By.cssSelector("input#email"));
        WebElement passwordInputField = driver.findElement(By.cssSelector("input#password"));
        emailInputField.sendKeys("*****");
        passwordInputField.sendKeys("*****");
        WebElement nextButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        nextButton.click();
        WebElement navBar = driver.findElement(By.xpath("//nav[@class=\"redesign-sidebar-nav\"]"));
        WebElement expenseModule = navBar.findElement(
                By.xpath(".//span[normalize-space()='Expenses']")
        );
        expenseModule.click();

        WebElement createNewExpenseButton = driver.findElement(By.xpath("//button[@type=\"button\" and text()=\"New Expense\"] "));
        createNewExpenseButton.click();
        WebElement dropdown = driver.findElement(
                By.xpath("//div[contains(@class,'dropdownselect-form')]" +
                        "[.//span[contains(normalize-space(.),'Expense Category')]]")
        );

        dropdown.findElement(
                By.xpath(".//div[contains(@class,'selected-value-box')]")
        ).click();

        List<WebElement> options = driver.findElements(
                By.xpath("//div[contains(@class,'option')]//div[contains(@class,'selected_text')]")
        );

        System.out.println("Options found: " + options.size());

        for (WebElement option : options) {
            System.out.println("TEXT = [" + option.getText() + "]");
        }
    }
}
