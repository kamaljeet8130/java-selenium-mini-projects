import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {
    WebDriver driver;
    String baseUrl = "https://the-internet.herokuapp.com";

    @BeforeMethod
    public void getDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void elementOnPageThatIsHidden() {
        String endpoint = "/dynamic_loading/1";
        driver.get(baseUrl + endpoint);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        String text = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")))
                .getText();
        System.out.println(text);
    }

    @Test
    public void ElementRenderedAfterTheFact() {
        driver.get(baseUrl + "/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        if (startButton.isDisplayed()) {
            startButton.click();
//            WebElement text = driver.findElement(By.id("finish"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
            System.out.println(text.getText());
        }
        driver.quit();
    }

    @Test
    public void dynamicControlsEnableDisableInputBox() {
        driver.get(baseUrl + "/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#input-example>button")).click();
            WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example>input")));
        inputBox.sendKeys("Hello world");
        Assert.assertEquals(inputBox.getAttribute("value"),"Hello wrld" , "value mis match");
        // inputBox.sendKeys("Hello");  >>> will give ElementNotInteractableException : element not interactable  (if used directly) without any waits
    }
    @Test
    public void verifyCheckboxIsPresentOnPageLoad(){
        driver.get(baseUrl + "/dynamic_controls");
        WebElement checkBox = driver.findElement(By.cssSelector("#checkbox-example #checkbox"));
        WebElement dynamicButton = driver.findElement(By.cssSelector("#checkbox-example button"));
        Assert.assertTrue(checkBox.isDisplayed(),"Checkbox should be visible");
        Assert.assertTrue(checkBox.isEnabled(),"Checkbox should be enabled");
        Assert.assertFalse(checkBox.isSelected(),"Checkbox should not be selected");
        Assert.assertEquals(dynamicButton.getText(),"Remove","Button text mismatch");
        Assert.assertTrue(dynamicButton.isEnabled(),"Button should be enabled");
    }
    @Test
    public void verifyCheckboxIsRemovedWhenRemoveButtonClicked(){
        driver.get(baseUrl+ "/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement checkBox = driver.findElement(By.id("checkbox"));
        WebElement dynamicButton = driver.findElement(By.cssSelector("#checkbox-example button"));
        dynamicButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        Assert.assertFalse(checkBox.isDisplayed(),"checkbox is still displayed");
    }


}