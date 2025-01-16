package testPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DuckduckgoHomePage;
import testBase.TestBase;

public class DuckduckgoHomeTests extends TestBase {
    DuckduckgoHomePage home;

    @BeforeMethod
    public void setup() {
        home = new DuckduckgoHomePage(driver);
        home.navigate();
    }

    @Test
    public void verifyPageTitleIsGoogle() {
        String pageTitle = home.getPageTitle();
        Assert.assertEquals(pageTitle, "Google", "Title is not as expected!");
    }

    @Test
    public void verifyPageLogoIsDisplayed(){
        boolean pageLogoIsDisplayed = home.isLogoDisplayed();
        Assert.assertTrue(pageLogoIsDisplayed);
    }
}
