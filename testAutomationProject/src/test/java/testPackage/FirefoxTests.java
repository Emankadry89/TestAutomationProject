package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
    FirefoxOptions firefoxOptions;
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;

    @BeforeClass
    public void beforeClass() {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.enableBiDi();
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);
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
                    String forthResultTitle =  searchResults.getForthResultTitle();
                    Assert.assertEquals(forthResultTitle, "TestNG Tutorial - GeeksforGeeks");
                    return true;
                });

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
