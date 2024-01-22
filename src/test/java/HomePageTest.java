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

import java.time.Duration;
import java.util.List;


public class HomePageTest {

    public WebDriver driver;
    public WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");
        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyHomeText(){
        String HomeText = homePage.getHomeText();
        String expHomeText = "Home";

        Assert.assertEquals(HomeText, expHomeText, "Home Text is not matching..");
    }

    @Test(priority = 2)
    public void verifyHomeMovieHeadingAndDesc(){
        String homeMovieHeading = homePage.getHomeMovieHeading();
        System.out.println(homeMovieHeading);

        String homeMovieDesc = homePage.getHomeMovieDescription();
        System.out.println(homeMovieDesc);
    }

    @Test(priority = 3)
    public void verifyIsPlayBtnDisplay(){
        WebElement playBtnEl = homePage.getPlayBtnEl();

        Assert.assertTrue(playBtnEl.isDisplayed(), "Play button is not displaying..");
    }

    @Test(priority = 4)
    public void verifyHeadingTextOfEachSection(){
        List<WebElement> headingTexts = homePage.getHeadingTexts();
        String headingText1 = headingTexts.get(0).getText();
        String expHeadingText1 = "Trending Now";

        Assert.assertEquals(headingText1, expHeadingText1, "First Section heading is not matching..");

        String headingText2 = headingTexts.get(1).getText();
        String expHeadingText2 = "Originals";

        Assert.assertEquals(headingText2, expHeadingText2, "Second Section heading is not matching..");

    }

    @Test(priority = 5)
    public void verifyMoviesListInMoviesSection(){
        List<WebElement> moviesList = homePage.getMoviesList();

        Assert.assertEquals(moviesList.size(), 20, "Movies count is not matching..");
    }

    @Test(priority = 6)
    public void verifyContactUsIcons(){
        List<WebElement> contactUsIcons = homePage.getContactIcons();

        Assert.assertEquals(contactUsIcons.size(), 4, "Contact Us Icons count is not matching..");
    }

    @Test(priority = 7)
    public void verifyContactUsText(){
        String contactUsText = homePage.getContactUsHeading();
        String expContactUsText = "Contact Us";

        Assert.assertEquals(contactUsText, expContactUsText, "Contact Us text is not matching..");
    }
}
