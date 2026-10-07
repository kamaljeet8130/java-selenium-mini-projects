package interactions.tables;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticWebTablesDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement staticTable = driver.findElement(By.xpath("//table[@name=\"BookTable\"]"));
        List<WebElement> tableColum = staticTable.findElements(By.xpath(".//th"));
        int rowCount = staticTable.findElements(By.xpath(".//tr")).size();
//        System.out.println(tableColum.size());
//        for(WebElement element : tableColum){
//            System.out.println(element.getText());
//        }

        //fetch the data for 1column 5th row!;

        System.out.println(staticTable.findElement(By.xpath(".//tr[5]/td[1]")).getText());

        //fetch the date from lastRow and 3column!
        System.out.println(staticTable.findElement(By.xpath(".//tr["+rowCount+"]/td[3]")).getText());

        ///fetch the bookName whose author is Mukesh
        List<WebElement> authorName = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//td[2]"));

        for(WebElement author : authorName){
            String name ="Mukesh";
            if(author.getText().equals(name)){
                System.out.println(author.findElement(By.xpath(".//preceding-sibling::td[1]")).getText());
            }
        }

        //fetch all the book price and tell total price :
        List<WebElement> priceColum = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//td[4]"));
        int sum = 0;
        for(WebElement price: priceColum){
            int result = Integer.parseInt(price.getText());
            sum+=result;
        }
        System.out.println(sum);

        driver.quit();


    }
}

