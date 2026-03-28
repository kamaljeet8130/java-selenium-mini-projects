import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes extends BaseTest {
    final String CHECKBOX_ENDPOINT = "/checkboxes";
    By checkboxesLocator = By.cssSelector("#checkboxes input[type='checkbox']");

    private List<WebElement> getCheckboxes(){
        return driver.findElements(checkboxesLocator);
    }
    private int getCheckboxCount(){
        List<WebElement> checkboxes= getCheckboxes();
        return checkboxes.size();
    }
    private int getCheckedCheckboxCount(){
        int count = 0;
        for(WebElement checkbox:getCheckboxes()){
            if(checkbox.isSelected()){
                count++;
            }
        }
        return count;
    }
    private int getUncheckedCheckboxCount(){
        int count = 0;
        for(WebElement checkbox:getCheckboxes()){
            if(!checkbox.isSelected()){
                count++;
            }
        }
        return count;
    }
    private void checkedUncheckedCheckbox(){
        for(WebElement checkbox:getCheckboxes()){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
    }
    private void uncheckedCheckedCheckbox(){
        for(WebElement checkbox:getCheckboxes()){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }
    }

    @Test
    public void verifyCheckboxCount(){
        navigate(CHECKBOX_ENDPOINT);
        Assert.assertEquals(getCheckboxes().size(),2," Exactly 2 checkbox are not present on page");
    }

    @Test
    public void verifyInitialState(){
        navigate(CHECKBOX_ENDPOINT);
        int checkedCount = 0,uncheckedCount=0;
        for (WebElement checkbox:getCheckboxes()){
            if(checkbox.isSelected()){
                checkedCount++;
            }
            else{
                uncheckedCount++;
            }
        }
        Assert.assertEquals(checkedCount,1,"There should be exactly 1 checked checkbox");
        Assert.assertEquals(uncheckedCount,1,"There should be exactly 1 unchecked checkbox");
    }

    @Test
    public void verifyCheckingUnCheckCheckbox(){
        navigate(CHECKBOX_ENDPOINT);
        checkedUncheckedCheckbox();
        Assert.assertEquals(getCheckedCheckboxCount(),2);
    }

    @Test
    public void verifyUncheckingCheckCheckbox(){
        navigate(CHECKBOX_ENDPOINT);
        uncheckedCheckedCheckbox();
        Assert.assertEquals(getUncheckedCheckboxCount(),2);
    }

    @Test
    public void verifyIndividualCheckboxBehaviour(){
        navigate(CHECKBOX_ENDPOINT);
        List<WebElement> checkboxes = getCheckboxes();
        for(WebElement checkbox:checkboxes){
            System.out.println(checkbox.getText());
        }

    }
}
