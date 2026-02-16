import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        WebElement userNameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        userNameField.sendKeys("student");
        passwordField.sendKeys("Password123W");
        try{
            WebElement submitBtn = driver.findElement(By.id("submt"));
            if(submitBtn.isDisplayed()){
                submitBtn.click();
            }

        }catch (Exception e){
            System.err.println("Incorrect Login attempt");
        }finally{
            driver.quit();

        }
    }
}
