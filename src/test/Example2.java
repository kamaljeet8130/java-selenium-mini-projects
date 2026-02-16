
/*
* Practice Exercise - 1
Launch a new Chrome browser.
Open https://practicetestautomation.com/practice-test-login/
Get Page Title name and Title length
Print Page Title and Title length on the Eclipse Console.
Get Page URL and verify if it is a correct page opened
Get Page Source (HTML Source code) and Page Source length
Print Page Length on Eclipse Console.
Close the Browser.
* */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String url = "https://practicetestautomation.com/practice-test-login/";
        driver.get(url);
        String title = driver.getTitle();
        assert title!=null;
        int titleLength = title.length();
        System.out.println("Title of the page :: " + title);
        System.out.println("length of title :: " + titleLength);
        String actualUrl = driver.getCurrentUrl();
        try{
            assert  actualUrl!=null;
            if(actualUrl.equals(url)){
                System.out.println("Verification successful - The correct url is opened");
            }
            System.out.println("Actual url is : " + actualUrl);
            System.out.println("expected url is : " + url);
        }catch (Exception e){
            System.err.println("Verification isn't successful : Expected Url is " + url + " \n and actual Url is : " + actualUrl);
        }finally {
            String pageSource = driver.getPageSource();
            System.out.println(pageSource);
            assert pageSource!=null;
            int pageSourceLength = pageSource.length();
            System.out.println(pageSourceLength);
            driver.close();
        }
    }
}
