package pakages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountsPage {

    WebDriver driver;
    WebDriverWait wait;

    By accountHeadingLocator = By.className("account-heading");
    By membershipHeadingsLocator = By.xpath("//p[@class='membership-heading']");
    By membershipUsernameLocator = By.className("membership-username");
    By membershipPswLocator = By.className("membership-password");
    By premiumLocator = By.className("plan-paragraph");
    By planDetailsLocator = By.className("plan-details");
    By logoutBtnLocator = By.className("logout-button");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getAccountHeading(){
        return driver.findElement(accountHeadingLocator).getText();
    }

    public List<WebElement> getMembershiHeads(){
        List<WebElement> membershipHeads = driver.findElements(membershipHeadingsLocator);
        return membershipHeads;
    }

    public String getMembershipUsername(){
        return driver.findElement(membershipUsernameLocator).getText();
    }

    public String getMembershipPsw(){
        return driver.findElement(membershipPswLocator).getText();
    }

    public String getPremiumDesc(){
        return driver.findElement(premiumLocator).getText();
    }

    public String getPlanDetails(){
        return driver.findElement(planDetailsLocator).getText();
    }

    public WebElement getLogoutBtn(){
        return driver.findElement(logoutBtnLocator);
    }
}

