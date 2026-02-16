import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/select-menu";
//        singleDropDown(driver,url);
//        multipleDropDown(driver,url);
//        task1(driver,url);
        task2(driver,url);


    }
    private static void singleDropDown(WebDriver driver,String url){
        try{
            driver.get(url);
            driver.manage().window().minimize();
            WebElement dropDownElement = driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
            Select select = new Select(dropDownElement);
            for(WebElement element : select.getOptions()){
                System.out.print(element.getText() + " ,");
            }
            }catch (Exception e){
            System.err.println("Invalid url");
        }finally {
            driver.close();
        }
    }
    private static void multipleDropDown(WebDriver driver,String url){
        driver.manage().window().maximize();
        driver.get(url);
        WebElement multiSelectDropDown = driver.findElement(By.xpath("//*[@id='cars']"));
        Select select = new Select(multiSelectDropDown);
        if(select.isMultiple()){
            select.selectByIndex(2);
            select.selectByIndex(3);
        }
        tearDown(driver);
    }

    private static void task1(WebDriver driver,String url){

        /*
 Launch the browser.
Open "https://demoqa.com/select-menu".
Select the Old Style Select Menu using the element id.
Print all the options of the dropdown.
Select 'Purple' using the index.
After that, select 'Magenta' using visible text.
Select an option using value.
Close the browser
        * */
        driver.manage().window().maximize();
        driver.get(url);
        WebElement dropDownElement = driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
        Select select = new Select(dropDownElement);
        System.out.println("The dropdown options are:");
        for(WebElement dropDownList : select.getOptions()){
            System.out.println(dropDownList.getText() + " , " );
        }
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("select Value : " + select.getFirstSelectedOption().getText());
        System.out.println("Select the Option by Visible Text");
        select.selectByVisibleText("Yellow");
        System.out.println("selected Value is  : " + select.getFirstSelectedOption().getText());
        System.out.println("Select the Option by value ");
        select.selectByValue("6");
        System.out.println("selected value is : " + select.getFirstSelectedOption().getText());

        tearDown(driver);

    }
    private static void task2(WebDriver driver,String url){
        /*
Launch the browser.
Open "https://demoqa.com/select-menu".
Select the Standard Multi-Select using the element id.
Verifying that the element is multi-select.
Select 'Opel' using the index and deselect the same using index.
Select 'Saab' using value and deselect the same using value.
Deselect all the options.
Close the browser.
        * */
        driver.manage().window().maximize();
        driver.get(url);
        WebElement multiSelectDropDown = driver.findElement(By.xpath("//*[@id='cars']"));
        Select options  = new Select(multiSelectDropDown);
        System.out.println("The dropdown options are -");
        for(WebElement option: options.getOptions()){
            System.out.println(option.getText());
        }
        if(options.isMultiple()){
            System.out.println("Select option  by Visible Text");
            options.selectByVisibleText("Opel");

            System.out.println("select option by value");
            options.selectByValue("saab");

            System.out.println("List of selected value");
            for(WebElement element : options.getAllSelectedOptions()){
                System.out.println(element.getText());
            }

        }
        tearDown(driver);
    }
    private static void tearDown(WebDriver driver){
        driver.quit();
    }
}
