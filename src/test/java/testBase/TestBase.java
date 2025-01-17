package testBase;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.BrowserFactory;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    public Wait<WebDriver> wait;

    @BeforeMethod
    @Parameters({"target-browser"})
    public void setup(@Optional("chrome") String browser) throws MalformedURLException, URISyntaxException {
        driver = BrowserFactory.getDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}
