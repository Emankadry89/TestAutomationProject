package testPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.SeleniumWaitPracticePage;
import testBase.TestBase;

public class SeleniumWaitPracticeTest extends TestBase {

    SeleniumWaitPracticePage waitPractice;

    @BeforeMethod
    public void setup(){
        waitPractice = new SeleniumWaitPracticePage(driver);
        waitPractice.navigate();
    }

    @Test
    public void verifyRedBoxIsDisplayed(){
        waitPractice.clickOnAddBox();
        wait.until(
                d -> {
        boolean redBoxIsDisplayed = waitPractice.verifyRedBoxDisplay();
        Assert.assertTrue(redBoxIsDisplayed);
                    return true;
                });
    }
}
