import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pakages.AccountsPage;
import pakages.HomePage;
import pakages.LoginPage;

import java.time.Duration;
import java.util.List;

public class AccountPageTest {

    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountsPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");

        WebElement accountEl = homePage.getAvatarImgEl();
        accountEl.click();

        String expUrl2 = "https://qamoviesapp.ccbp.tech/account";

        Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Account page URL is not matching..");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test(priority = 1)
    public void accountPageUiTest(){
        String accountHeading = accountPage.getAccountHeading();
        List<WebElement> membershipHeads = accountPage.getMembershiHeads();
        String membershipHeading = membershipHeads.get(0).getText();
        String planDetailsHead = membershipHeads.get(1).getText();
        String membershipUsername = accountPage.getMembershipUsername();
        String membershipPsw = accountPage.getMembershipPsw();
        String premiumHead = accountPage.getPremiumDesc();
        String planDetails = accountPage.getPlanDetails();
        WebElement logoutBtnEl = accountPage.getLogoutBtn();

        Assert.assertEquals(accountHeading, "Account", "Account heading is not matching..");
        Assert.assertEquals(membershipHeading, "Member ship", "Membership heading is not matching..");
        Assert.assertEquals(planDetailsHead, "Plan details", "Plan Details head is not matching..");
        Assert.assertEquals(membershipUsername, "User name : rahul", "Membership username is not matching..");
        Assert.assertEquals(membershipPsw, "Password : **********", "Membership password is not matching..");
        Assert.assertEquals(premiumHead, "Premium", "Premium text is not matching..");
        Assert.assertEquals(planDetails, "Ultra HD", "Plan details is not matching..");
        Assert.assertTrue(logoutBtnEl.isDisplayed(),"Logout button is not displayed..");

    }

    @Test(priority = 2)
    public void logoutFunctionalityTest(){
        WebElement logoutBtnEl = accountPage.getLogoutBtn();
        logoutBtnEl.click();

        String expUrl = "https://qamoviesapp.ccbp.tech/login";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URLs are not matching..");
    }
}
