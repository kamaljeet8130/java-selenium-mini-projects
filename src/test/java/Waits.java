import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest {

    @Test
    public void elementOnPageThatIsHidden() {
        String endpoint = "/dynamic_loading/1";
        navigate(endpoint);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        String text = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")))
                .getText();
    }

    @Test
    public void ElementRenderedAfterTheFact() {
        navigate(  "/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        if (startButton.isDisplayed()) {
            startButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        }
        driver.quit();
    }

    @Test
    public void dynamicControlsEnableDisableInputBox() {
        navigate(  "/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#input-example>button")).click();
        WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example>input")));
        inputBox.sendKeys("Hello world");
        Assert.assertEquals(inputBox.getAttribute("value"), "Hello wrld", "value mis match");
        // inputBox.sendKeys("Hello");  >>> will give ElementNotInteractableException : element not interactable  (if used directly) without any waits
    }

    @Test
    public void verifyCheckboxIsPresentOnPageLoad() {
        navigate( "/dynamic_controls");
        WebElement checkBox = driver.findElement(By.cssSelector("#checkbox-example #checkbox"));
        WebElement dynamicButton = driver.findElement(By.cssSelector("#checkbox-example button"));
        Assert.assertTrue(checkBox.isDisplayed(), "Checkbox should be visible");
        Assert.assertTrue(checkBox.isEnabled(), "Checkbox should be enabled");
        Assert.assertFalse(checkBox.isSelected(), "Checkbox should not be selected");
        Assert.assertEquals(dynamicButton.getText(), "Remove", "Button text mismatch");
        Assert.assertTrue(dynamicButton.isEnabled(), "Button should be enabled");
    }

    @Test
    public void verifyCheckboxIsRemovedWhenRemoveButtonClicked() {
        navigate(  "/dynamic_controls");
        By dynamicButtonLocator = By.cssSelector("#checkbox-example button");
        By checkboxLocator = By.id("checkbox");
        By message = By.id("message");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(dynamicButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkboxLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        Assert.assertEquals(driver.findElement(message).getText(), "It's gone", "message did not appear");
        Assert.assertTrue(driver.findElements(checkboxLocator).isEmpty(), "checkbox is still displayed");
    }

    @Test
    public void verifyCheckboxIsAddedWhenAddButtonClicked() {
        navigate(  "/dynamic_controls");
        By buttonLocator = By.cssSelector("#checkbox-example button");
        By checkBoxLocator = By.id("checkbox");
        By messageLocator = By.id("message");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBoxLocator));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(buttonLocator, "Add"));
        Assert.assertEquals(driver.findElement(messageLocator).getText(), "It's gone!");
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(buttonLocator, "Remove"));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxLocator));
        Assert.assertEquals(driver.findElement(buttonLocator).getText(), "Remove", "button text did not changed!");
        Assert.assertTrue(driver.findElement(checkBoxLocator).isDisplayed());
        Assert.assertEquals(driver.findElement(messageLocator).getText(), "It's back!");
    }

    @Test
    public void verifyButtonTextChangesAfterRemovingCheckbox() {
        navigate(  "/dynamic_controls");
        By buttonLocator = By.cssSelector("#checkbox-example button");
        By messageLocator = By.id("message");
        WebDriverWait wait   = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(buttonLocator,"Add"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
        String buttonText = driver.findElement(buttonLocator).getText();
        Assert.assertEquals(buttonText,"Add");
        String messageText = driver.findElement(messageLocator).getText();
        Assert.assertEquals(messageText,"It's gone!");
    }

    @Test
    public void verifyButtonTextChangesAfterAddingCheckbox(){
        navigate(  "/dynamic_controls");
        By buttonLocator = By.cssSelector("#checkbox-example button");
        By messageLocator = By.id("message");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(buttonLocator,"Add"));
        Assert.assertEquals(driver.findElement(buttonLocator).getText(),"Add");
        driver.findElement(buttonLocator).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(buttonLocator,"Remove"));
        Assert.assertEquals(driver.findElement(buttonLocator).getText(),"Remove");
        Assert.assertEquals(driver.findElement(messageLocator).getText(),"It's back!");
    }
    @Test
    public void verifyInputFieldIsDisabledByDefault(){
        navigate( "/dynamic_controls");
        By inputFieldLocator = By.cssSelector("#input-example input");
        WebElement inputField = driver.findElement(inputFieldLocator);
        Assert.assertTrue(inputField.isDisplayed());
        Assert.assertFalse(inputField.isEnabled(),
                "Input field should be disabled by default");
    }

    @Test
    public void verifyInputFieldIsEnabledWhenEnableButtonClicked(){
        navigate(  "/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        By inputFieldLocator = By.cssSelector("#input-example input");
        By enableDisableButtonLocator = By.cssSelector("#input-example button");
        WebElement inputField = driver.findElement(inputFieldLocator);
        Assert.assertFalse(inputField.isEnabled());
        driver.findElement(enableDisableButtonLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        Assert.assertTrue(inputField.isEnabled());
        inputField.sendKeys("Hello world");
        Assert.assertEquals(inputField.getAttribute("value"),"Hello world");
    }

    @Test
    public void verifyUserCanEnterTextAfterInputIsEnabled(){
        navigate(  "/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        By inputFieldLocator = By.cssSelector("#input-example input");
        By enableDisableButtonLocator = By.cssSelector("#input-example button");
        WebElement inputField = driver.findElement(inputFieldLocator);
        driver.findElement(enableDisableButtonLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        String inputString = "Hello world";
        inputField.sendKeys(inputString);
        Assert.assertEquals(inputField.getAttribute("value"),inputString);
    }

    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
        }
    }

}