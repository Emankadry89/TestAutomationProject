package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.W3SchoolTablePage;

import java.time.Duration;

public class W3SchoolTableTests {

    WebDriver driver;
    Wait<WebDriver> wait;
    ChromeOptions chromeOptions;
    W3SchoolTablePage table;

    @BeforeClass
    public void beforeClass() {
        chromeOptions = new ChromeOptions();
        chromeOptions.enableBiDi();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);
        table = new W3SchoolTablePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        table.navigate();
    }

    @Test
    public void verifyErnstHandleCountry() {
        wait.until(
                d -> {
                    String ernstHandleCountry = table.getErnstHandelCountry();
                    Assert.assertEquals(ernstHandleCountry, "Austria");
                    return true;
                });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
