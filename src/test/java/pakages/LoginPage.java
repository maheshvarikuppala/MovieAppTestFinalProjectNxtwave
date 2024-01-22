package pakages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By loginImgLocator = By.className("login-website-logo");
    By loginHeadingLocator = By.className("sign-in-heading");
    By labeltextsLocator = By.xpath("//label[@class='input-label']");
    By usernameLocator = By.id("usernameInput");
    By pswLocator = By.id("passwordInput");
    By loginBtnLocator = By.className("login-button");
    By errMsgLocator = By.className("error-message");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findLoginImg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginImgLocator));
        return driver.findElement(loginImgLocator);
    }

    public String getLoginHeading(){
        WebElement loginHeadingEl = driver.findElement(loginHeadingLocator);
        return loginHeadingEl.getText();
    }

    public String getLabelText(int index){
        List<WebElement> labelTexts = driver.findElements(labeltextsLocator);

        return labelTexts.get(index).getText();
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String psw){
        driver.findElement(pswLocator).sendKeys(psw);
    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtnLocator).submit();
    }

    public void loginToApplication(String username,String psw){
        enterUsername(username);
        enterPassword(psw);
        clickOnLoginBtn();
    }

    public String getErrMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsgLocator));

        return driver.findElement(errMsgLocator).getText();
    }
}
