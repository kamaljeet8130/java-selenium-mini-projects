package webdrivermethods.conditionalmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// conditional methods can apply on web elements!
/*
isDisplayed() --- element is displayed on page or not
isEnabled() -- element is enabled on not
isSelected() -- element is selected or not
 */
public class ConditionalMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        driver.manage().window().maximize();
        WebElement logo = driver.findElement(By.cssSelector("div#entry_217821"));
        boolean isLogoDisplayed = logo.isDisplayed();
        System.out.println(isLogoDisplayed);

        WebElement firstNameInputBox = driver.findElement(By.cssSelector("input#input-firstname"));
        if(firstNameInputBox.isEnabled()){
            firstNameInputBox.sendKeys("Hello worlds");
        }
        WebElement subscribeNoRadioButton  = driver.findElement(By.cssSelector("input#input-newsletter-no"));
        boolean isNOButtonSelected = subscribeNoRadioButton.isSelected();
        System.out.println(isNOButtonSelected);

    }
}
