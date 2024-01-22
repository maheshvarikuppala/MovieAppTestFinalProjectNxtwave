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

import java.time.Duration;
import java.util.List;

public class PopularPageTest {

    public WebDriver driver;
    public WebDriverWait wait;

    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");

        WebElement popularEl = homePage.getPopularEl();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        popularEl.click();

        String expUrl2 = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Popular Section URL is not matching..");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void verifyMoviesDisplayed(){
        List<WebElement> popularMovies = popularPage.getPopularMoviesList();

        for(WebElement movie:popularMovies){
            Assert.assertTrue(movie.isDisplayed(), "Some movies are not displaying in Popular Section");
        }
    }
}
