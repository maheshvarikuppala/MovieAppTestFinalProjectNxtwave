package pakages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {

    WebDriver driver;
    WebDriverWait wait;

    By popularMoviesLocator = By.xpath("//li[@class='movie-icon-item']");

    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<WebElement> getPopularMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularMoviesLocator));
        List<WebElement> popularMovies = driver.findElements(popularMoviesLocator);

        return popularMovies;
    }
}
