package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static WebDriver driver;
    String baseUrl = "https://the-internet.herokuapp.com";

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public void navigate(String path){
        driver.get(baseUrl + path);
    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
