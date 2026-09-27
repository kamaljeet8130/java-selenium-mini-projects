package sceneriobasedquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownDemos {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement dropdown = driver.findElement(By.cssSelector("select.form-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

//        List<WebElement> options  = select.getOptions();
//        for(WebElement option : options){
//            if (option.getText().equals("Two")){
//                option.click();
//                break;
//            }
//        }
//        int optionSize = options.size();
//        select.selectByIndex(optionSize-1);
//        System.out.println(select.getFirstSelectedOption().getText());

        WebElement dataListInput  =driver.findElement(By.id("my-options"));
        List<WebElement> options = dataListInput.findElements(By.tagName("options"));
        for(WebElement option: options){
            String value = option.getAttribute("value");
            if(value.toLowerCase().contains("s"))
                System.out.println(value);
        }


    }
}
