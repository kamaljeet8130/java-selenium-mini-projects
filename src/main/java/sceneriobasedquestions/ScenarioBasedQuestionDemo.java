package sceneriobasedquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ScenarioBasedQuestionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String pageTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Web form",pageTitle );

        WebElement inputText = driver.findElement(By.cssSelector("input#my-text-id"));
        inputText.sendKeys("kamaljeet");
        System.out.println(inputText.getAttribute("value"));

        WebElement passwordInputField = driver.findElement(By.xpath("//label[normalize-space(text())=\"Password\"]/input[@type=\"password\"]"));
        passwordInputField.sendKeys("Text@234");

        WebElement textAreaField = driver.findElement(By.xpath("//label[normalize-space(text())=\"Textarea\"]/textarea[@name=\"my-textarea\"]"));
        textAreaField.sendKeys("something bigß");
        System.out.println(textAreaField.getAttribute("value"));

        WebElement disabledInputField = driver.findElement(By.xpath("//input[@type=\"text\" and @placeholder=\"Disabled input\"]"));
        boolean isInputFieldDisabled = disabledInputField.isEnabled();
        System.out.println(isInputFieldDisabled);

        WebElement readOnlyInputFiled = driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"my-readonly\"]"));
        String before = readOnlyInputFiled.getAttribute("value");
        readOnlyInputFiled.sendKeys("kamalJeet");
        String after = readOnlyInputFiled.getAttribute("value");
        System.out.println(before.equals(after));

        //checkboxes
        List<WebElement> checkboxes  = driver.findElements(By.xpath("//div[@class=\"form-check\"]/label/input[@type=\"checkbox\"]"));
        for(WebElement checkbox : checkboxes){
            String label  = checkbox.findElement(By.xpath("..")).getText();
            System.out.println(label + " : is selected " + checkbox.isSelected());
        }
        for(WebElement checkbox : checkboxes){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }
        WebElement dropdown = driver.findElement(By.cssSelector("select.form-select"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Two"); // if entering value which is not persent in dropdown will get no such element exception
        System.out.println(select.getFirstSelectedOption().getText());
//        driver.quit();


    }

}
