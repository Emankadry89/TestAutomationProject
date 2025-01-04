package testPackage;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DuckduckgoHomePage;
import pagePackage.DuckduckgoSearchResultsPage;

import java.time.Duration;

public class FirefoxTests {
    WebDriver driver;
    Wait<WebDriver> wait;
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
        home = new DuckduckgoHomePage(driver);
        searchResults = new DuckduckgoSearchResultsPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        home.navigate();
    }

    @Test
    public void verifyForthResultText() {
        home.searchForQuery("TestNG");
        wait.until(
                d -> {
                    searchResults.isForthResultTitleDisplayed();
                    return true;
                });
        String forthResultTitle = searchResults.getForthResultTitle();
        Assert.assertEquals(forthResultTitle, "TestNG Tutorial - GeeksforGeeks");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
