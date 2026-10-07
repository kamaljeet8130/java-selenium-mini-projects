package assingments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class DropdownAssignment {
    WebDriver driver;
    WebElement countryDropdown;
    WebElement stateDropDown;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");

    }

    @Test
    public void verifySelectCountryFromDropdown() {
        String countryToSelect = "India";
        countryDropdown = driver.findElement(By.cssSelector("select#country-list"));
        Select countrySelect = new Select(countryDropdown);
        List<WebElement> countryOptions = countrySelect.getOptions();
        for (WebElement option : countryOptions) {
            String country = option.getText();
            if (country.equals(countryToSelect)) {
                option.click();
            }
        }
        String selectedCountry = countrySelect.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedCountry, countryToSelect);
    }

    @Test
    public void verifyCountryDropdownIsDisplayedAndEnabled() {
        countryDropdown = driver.findElement(By.cssSelector("select#country-list"));
        Assert.assertTrue(countryDropdown.isDisplayed());
        Assert.assertTrue(countryDropdown.isEnabled());
    }

    @Test
    public void verifyCountryDropdownContainsAllExpectedCountries() {
        countryDropdown = driver.findElement(By.cssSelector("select#country-list"));
        Select countryList = new Select(countryDropdown);
        List<String> expectedCountryList = new ArrayList<>();
        expectedCountryList.add("Select Country");
        expectedCountryList.add("Brazil");
        expectedCountryList.add("China");
        expectedCountryList.add("France");
        expectedCountryList.add("India");
        expectedCountryList.add("USA");

        List<WebElement> options = countryList.getOptions();
        Assert.assertEquals(options.size(), expectedCountryList.size());
        for (int i = 0; i < options.size(); i++) {
            Assert.assertEquals(options.get(i).getText(), expectedCountryList.get(i));
        }
    }

    @Test
    public void VerifyTheDefaultValueOfCountryDropdown() {
        countryDropdown = driver.findElement(By.cssSelector("select#country-list"));
        Select countryList = new Select(countryDropdown);
        String defaultValue = "Select Country";
        Assert.assertEquals(countryList.getFirstSelectedOption().getText(), defaultValue);
    }

    @Test
    public  void verifyTheDefaultValueOfStateDropdown(){
        stateDropDown = driver.findElement(By.cssSelector("select#state-list"));
        Select stateSelect = new Select(stateDropDown);
        String defaultValue = "Select State";
        Assert.assertEquals(stateSelect.getFirstSelectedOption().getText(),defaultValue);
    }
    @Test
    public void verifySelectIndiaAndVerifyThatTheStateDropdownIsPopulatedWithIndianStates() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String countryToSelect = "India";
        countryDropdown = driver.findElement(By.cssSelector("select#country-list"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("India");
        String actualSelectedCounty = countrySelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedCounty,countryToSelect);
        Select stateSelect = new Select(stateDropDown);
        List<WebElement> stateOptions = stateSelect.getOptions();
        System.out.println(stateOptions.size());
        for(WebElement option : stateOptions){
            System.out.println(option.getText());
        }
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

