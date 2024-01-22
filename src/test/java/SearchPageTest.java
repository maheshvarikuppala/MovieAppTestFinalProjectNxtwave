import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pakages.HomePage;
import pakages.LoginPage;
import pakages.PopularPage;
import pakages.SearchPage;

import java.time.Duration;


public class SearchPageTest {

    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");

        WebElement searchEl = homePage.getSearchEl();
        searchEl.click();

        String expUrl2 = "https://qamoviesapp.ccbp.tech/search";

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Searl Section URL is not matching..");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



    @Test(priority = 1)
    public void searchFunctionalityTest1(){
        searchPage.searching("Titanic");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='link-item']")));
        WebElement movieImgEl = driver.findElement(By.xpath("//a[@class='link-item']"));
        Assert.assertTrue(movieImgEl.isDisplayed(), "Specific movie is not displaying..");
    }

    @Test(priority = 2)
    public void searchFunctionalityTest2(){
        searchPage.searching("Avatar");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        WebElement movieImgEl = driver.findElement(By.className("movie-image"));
        Assert.assertTrue(movieImgEl.isDisplayed(), "Specific movie is not displaying..");
    }

}
