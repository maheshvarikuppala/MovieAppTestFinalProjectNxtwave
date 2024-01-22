package pakages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By homeLocator = By.xpath("//a[text()='Home']");
    By homeMovieHeadingLocator = By.className("home-movie-heading");
    By homeMovieDescLocator = By.className("home-movie-description");
    By playBtnLocator = By.className("home-movie-play-button");
    By headingTextsLocators = By.xpath("//h1[@class = 'movies-list-heading']");
    By moviesLocators = By.xpath("//div[@class='react-slick-item']");
    By contactIconsLocators = By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactUsLocator = By.className("contact-us-paragraph");
    By moviesLogoLocator = By.className("website-logo");
    By popularLocator = By.xpath("//a[text()='Popular']");
    By avatarImgLocator = By.className("avatar-img");
    By searchLocator = By.xpath("//button[@class='search-empty-button']/child::*");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHomeText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLocator));
        return driver.findElement(homeLocator).getText();
    }


    public String getHomeMovieHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeMovieHeadingLocator));
        return driver.findElement(homeMovieHeadingLocator).getText();
    }

    public String getHomeMovieDescription(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeMovieDescLocator));
        return driver.findElement(homeMovieDescLocator).getText();
    }

    public WebElement getPlayBtnEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBtnLocator));
        return driver.findElement(playBtnLocator);
    }

    public List<WebElement> getHeadingTexts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingTextsLocators));
        return driver.findElements(headingTextsLocators);
    }

    public List<WebElement> getMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesLocators));
        List<WebElement> moviesList = driver.findElements(moviesLocators);
        return moviesList;
    }

    public List<WebElement> getContactIcons(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactIconsLocators));
        List<WebElement> contactIcons = driver.findElements(contactIconsLocators);
        return contactIcons;
    }

    public String getContactUsHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLocator));
        return driver.findElement(contactUsLocator).getText();
    }

    public WebElement getMoviesLogoEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesLogoLocator));
        return driver.findElement(moviesLogoLocator);
    }

    public String getPopularText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularLocator));
        return driver.findElement(popularLocator).getText();
    }

    public WebElement getAvatarImgEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarImgLocator));
        return driver.findElement(avatarImgLocator);
    }

    public WebElement getPopularEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularLocator));
        return driver.findElement(popularLocator);
    }

    public WebElement getHomeEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLocator));
        return driver.findElement(homeLocator);
    }

    public WebElement getSearchEl(){
        wait.until(ExpectedConditions.elementToBeClickable(searchLocator));
        return driver.findElement(searchLocator);
    }
}
