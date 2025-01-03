package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DuckduckgoHomePage;

public class DuckduckgoHomeTests {
    WebDriver driver;
    DuckduckgoHomePage home;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new DuckduckgoHomePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
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

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
