import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
       driver.findElement(userNameLocator).sendKeys("student");
       driver.findElement(passwordLocator).sendKeys("Password123");
       driver.findElement(submitButtonLocator).click();

        String actualUrl = driver.getCurrentUrl();
        if(actualUrl!=null && actualUrl.equals(url)){
           throw new RuntimeException("URL Validation Failed");
       }
       String expectedTitle = "Logged In Successfully | Practice Test Automation";
       String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title Validation Failed");
        assert actualTitle != null;
        System.out.println("actual Title length  : "  + actualTitle.length() + " :::: " + "expected length : " + expectedTitle.length());
//       if(actualTitle!=null && actualTitle.equals(expectedTitle)){
//           throw new RuntimeException(
//                   "Title Validation Failed\n" +
//                           "Actual: [" + actualTitle + "]\n" +
//                           "Expected: [" + expectedTitle + "]"
//           );
//       }
       WebElement header = driver.findElement(By.tagName("h1"));
       if(!header.getText().equals("Logged In Successfully")){
           throw new RuntimeException("Header Validation Failed");
       }
       WebElement logoutBtn = driver.findElement(By.linkText("Log out"));
       if(!logoutBtn.isDisplayed()){
           throw new RuntimeException("Logout button not visible");
       }
        System.out.println("All validation passed ");

    }
    private static void
}


