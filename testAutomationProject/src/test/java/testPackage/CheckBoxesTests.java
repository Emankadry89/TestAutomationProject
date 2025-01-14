package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagePackage.CheckBoxesPage;
import utils.BrowserFactory;

public class CheckBoxesTests {

    WebDriver driver;
    CheckBoxesPage checkBoxes;

    @BeforeMethod
    @Parameters({"target-browser"})
    public void setup(@Optional("chrome") String browser) {
        driver = BrowserFactory.getDriver();
        checkBoxes = new CheckBoxesPage(driver);
        checkBoxes.openCheckBoxesPage();
    }

    @Test
    public void checkFirstCheckBox() {
        checkBoxes.checkCheckBox1();
    }

    @Test(dependsOnMethods = "checkFirstCheckBox")
    public void verifySecondCheckBoxIsChecked() {
        boolean checkBox2IsChecked = checkBoxes.isCheckBox2Checked();
        Assert.assertTrue(checkBox2IsChecked);
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.quitDriver();
    }
}
