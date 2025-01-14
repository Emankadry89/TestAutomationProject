package testPackage;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.SeleniumWaitPracticePage;
import java.time.Duration;

public class SeleniumWaitPracticeTest {

    WebDriver driver;
    SeleniumWaitPracticePage waitPractice;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        waitPractice = new SeleniumWaitPracticePage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        waitPractice.navigate();
    }

    @Test
    public void verifyRedBoxIsDisplayed(){
        waitPractice.clickOnAddBox();
        boolean redBoxIsDisplayed = waitPractice.verifyRedBoxDisplay();
        Assert.assertTrue(redBoxIsDisplayed);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
