package testPackage;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class DuckduckgoSearchResultsTests {
    WebDriver driver;
    Wait<WebDriver> wait;
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;
    Map<String, String> testData;

    @BeforeClass
    public void beforeClass() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(300)).ignoring(ElementNotInteractableException.class).ignoring(NoSuchElementException.class);
        home = new DuckduckgoHomePage(driver);
        searchResults = new DuckduckgoSearchResultsPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/searchData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        home.navigate();
    }

    @Test
    public void verifyFirstResultLink() {
        String firstSearchQuery = testData.get("firstSearchTerm");
        home.searchForQuery(firstSearchQuery);
        String firstResultLink = searchResults.getFirstResultLink();
        String firstExpectedLink = testData.get("firstExpectedLink");
        Assert.assertEquals(firstResultLink, firstExpectedLink);
    }

    @Test
    public void verifyTheLinkOfSecondResult() {
        String secondSearchQuery = testData.get("secondSearchTerm");
        home.searchForQuery(secondSearchQuery);
        searchResults.scrollDown();
        searchResults.clickMoreResultsButton();
        wait.until(d -> {
            String secondPageSecondResultLink = searchResults.getSecondPageSecondResultLink();
            String secondExpectedLink = testData.get("secondExpectedLink");
            Assert.assertTrue(secondPageSecondResultLink.contains(secondExpectedLink));
            return true;
        });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
