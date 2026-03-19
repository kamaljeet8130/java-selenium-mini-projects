import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes extends BaseTest {
    final String CHECKBOX_ENDPOINT = "/checkboxes";
    By checkboxesLocator = By.cssSelector("#checkboxes input[type='checkbox']");


    @Test
    public void verifyCheckboxCount(){
        navigate(CHECKBOX_ENDPOINT);
        List<WebElement> checkboxes = driver.findElements(checkboxesLocator);
        Assert.assertEquals(checkboxes.size(),2," Exactly 2 checkbox are not present on page");
    }

    @Test
    public void verifyInitialState(){
        navigate(CHECKBOX_ENDPOINT);
        List<WebElement> checkboxes = driver.findElements(checkboxesLocator);
        Assert.assertFalse(checkboxes.get(0).isSelected(),"checkbox 1 is not unchecked initially");
        Assert.assertTrue(checkboxes.get(1).isSelected(),"checkbox 2 is not checked initially");

    }

}
