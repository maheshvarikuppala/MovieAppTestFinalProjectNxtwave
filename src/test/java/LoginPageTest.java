import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pakages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginPageUiTest(){
        WebElement loginImgEl = loginPage.findLoginImg();
        Assert.assertTrue(loginImgEl.isDisplayed(), "Website Logo Image is not displaying...");

        String usernameLabelText = loginPage.getLabelText(0);
        String expUserId = "USERNAME";

        Assert.assertEquals(usernameLabelText, expUserId, "USERNAME label text is not matching..");

        String pswLabelText = loginPage.getLabelText(1);
        String expPin = "PASSWORD";

        Assert.assertEquals(pswLabelText, expPin, "PIN label text is not matching..");

        String loginHeading = loginPage.getLoginHeading();
        String expLoginHeading = "Login";

        Assert.assertEquals(loginHeading, expLoginHeading, "Login heading is not matching..");

    }

    @Test(priority = 2)
    public void loginWithEmptyInputs(){
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrMsg();
        String expErrMsg = "*Username or password is invalid";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty input fields is not matching..");
    }

    @Test(priority = 3)
    public void loginWithEmptyUsername(){
        loginPage.enterPassword("rahul@2021");
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrMsg();
        String expErrMsg = "*Username or password is invalid";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty user name field is not matching..");
    }

    @Test(priority = 4)
    public void loginWithEmptyPassword(){
        loginPage.enterUsername("rahul");
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrMsg();
        String expErrMsg = "*Username or password is invalid";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty password field is not matching..");
    }

    @Test(priority = 5)
    public void loginWithInvalidUsername(){
        loginPage.loginToApplication("ravi", "rahul@2021");
        String errMsg = loginPage.getErrMsg();
        String expErrMsg = "*invalid username";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with invalid user name is not matching..");
    }

    @Test(priority = 6)
    public void loginWithInvalidPassword(){
        loginPage.loginToApplication("rahul", "rahul@222");
        String errMsg = loginPage.getErrMsg();
        String expErrMsg = "*username and password didn't match";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with invalid password is not matching..");
    }

    @Test(priority = 7)
    public void loginWithInvalidCreds(){
        loginPage.loginToApplication("ravi", "rahul@222");
        String errMsg = loginPage.getErrMsg();
        String expErrMsg = "*invalid username";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with both invalid username and password is not matching..");
    }

    @Test(priority = 8)
    public void loginWithValidCreds(){
        loginPage.loginToApplication("rahul", "rahul@2021");

        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");

    }

}
