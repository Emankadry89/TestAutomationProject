package testPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DuckduckgoHomePage;
import pagePackage.DuckduckgoSearchResultsPage;
import testBase.TestBase;
import utils.JsonReader;
import java.io.IOException;
import java.util.Map;

public class DuckduckgoSearchResultsTests extends TestBase {
    DuckduckgoHomePage home;
    DuckduckgoSearchResultsPage searchResults;
    Map<String, String> testData;

    @BeforeMethod
    public void setup() throws IOException {
        home = new DuckduckgoHomePage(driver);
        searchResults = new DuckduckgoSearchResultsPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/searchData.json");
        home.navigate();
    }

    @Test
    public void verifyFirstResultLink() {
        String firstSearchQuery = testData.get("firstSearchTerm");
        home.searchForQuery(firstSearchQuery);
        String firstResultLink = searchResults.getFirstResultLink(1);
        String firstExpectedLink = testData.get("firstExpectedLink");
        Assert.assertEquals(firstResultLink, firstExpectedLink);
    }

    @Test
    public void verifyTheLinkOfSecondResult() {
        String secondSearchQuery = testData.get("secondSearchTerm");
        home.searchForQuery(secondSearchQuery);
        wait.until(d -> {
            String secondPageSecondResultLink = searchResults.getSecondPageSecondResultLink(2);
            String secondExpectedLink = testData.get("secondExpectedLink");
            Assert.assertTrue(secondPageSecondResultLink.contains(secondExpectedLink));
            return true;
        });
    }

}
