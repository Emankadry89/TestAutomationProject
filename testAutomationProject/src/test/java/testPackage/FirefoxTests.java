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
import utils.JsonReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class FirefoxTests {
    WebDriver driver;
    Wait<WebDriver> wait;
    FirefoxOptions firefoxOptions;
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;
    Map<String, String> testData;

    @BeforeClass
    public void beforeClass() throws IOException {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.enableBiDi();
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);
        home = new DuckduckgoHomePage(driver);
        searchResults = new DuckduckgoSearchResultsPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/searchData.json");
    }

    @BeforeMethod
    public void beforeMethod() {

        home.navigate();
    }

    @Test
    public void verifyForthResultText() {
        String searchQuery = testData.get("firefoxSearchTerm");
        home.searchForQuery(searchQuery);
        wait.until(
                d -> {
                    String forthResultTitle =  searchResults.getForthResultTitle();
                    String expectedTitle = testData.get("firefoxExpectedTitle");
                    Assert.assertEquals(forthResultTitle, expectedTitle);
                    return true;
                });

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
