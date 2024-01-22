package pakages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchLocator = By.id("search");
    By searchIconLocator = By.xpath("//button[@class='search-button']/child::*");

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getSearchEl(){
        return driver.findElement(searchLocator);
    }

    public WebElement getSearchIconEl(){
        return driver.findElement(searchIconLocator);
    }

    public void searching(String movieName){
        WebElement searchInputEl = getSearchEl();
        searchInputEl.sendKeys(movieName);
        WebElement searchIconEl = getSearchIconEl();
        searchIconEl.click();

    }
}
