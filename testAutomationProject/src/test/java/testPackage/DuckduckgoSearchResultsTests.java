package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DuckduckgoHomePage;
import pagePackage.DuckduckgoSearchResultsPage;

public class DuckduckgoSearchResultsTests {
    WebDriver driver;
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new DuckduckgoHomePage(driver);
        searchResults = new DuckduckgoSearchResultsPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        home.navigate();
    }

    @Test
    public void verifyFirstResultLink(){
        home.searchForQuery("Selenium WebDriver");
        String firstResultLink = searchResults.getFirstResultLink();
        Assert.assertEquals(firstResultLink,"https://www.selenium.dev/documentation/webdriver/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
