import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "https://practicetestautomation.com/practice-test-login/";
        By userNameLocator = By.cssSelector("input#username");
        By passwordLocator = By.cssSelector("input#password");
        By submitButtonLocator = By.cssSelector("button#submit");
        validUserLogin(driver,url,userNameLocator,passwordLocator,submitButtonLocator);

    }
    private static void validUserLogin(WebDriver driver , String url ,By userNameLocator,By passwordLocator,By submitButtonLocator) throws InterruptedException {
        driver.get(url);
        WebElement userNameInput = driver.findElement(userNameLocator);
        WebElement passwordInput = driver.findElement(passwordLocator);
        userNameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");
        WebElement submitButton  = driver.findElement(submitButtonLocator);
        submitButton.click();
        driver.quit();
    }
}
