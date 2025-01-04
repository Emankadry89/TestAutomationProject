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

import java.time.Duration;

public class DuckduckgoSearchResultsTests {
    WebDriver driver;
    Wait<WebDriver> wait;
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    public void verifyFirstResultLink() {
        home.searchForQuery("Selenium WebDriver");
        String firstResultLink = searchResults.getFirstResultLink();
        Assert.assertEquals(firstResultLink, "https://www.selenium.dev/documentation/webdriver/");
    }

    @Test
    public void verifyTheLinkOfSecondResult() {
        home.searchForQuery("Cucumber IO");
        searchResults.scrollDown();
        searchResults.clickMoreResultsButton();
        wait.until(
                d -> {
                    String secondPageSecondResultLink = searchResults.getSecondPageSecondResultLink();
                    Assert.assertTrue(secondPageSecondResultLink.contains("https://www.linkedin.com"));
                    return true;
                });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
