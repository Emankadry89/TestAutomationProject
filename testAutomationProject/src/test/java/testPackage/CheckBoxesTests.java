package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagePackage.CheckBoxesPage;
import utils.BrowserFactory;

public class CheckBoxesTests {

    WebDriver driver;
    CheckBoxesPage checkBoxes;

    @BeforeClass
    @Parameters({ "target-browser" })
    public void beforeClass(@Optional("chrome") String browser){
        driver= BrowserFactory.getDriver();
        checkBoxes = new CheckBoxesPage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        checkBoxes.openCheckBoxesPage();
    }

    @Test
    public void checkFirstCheckBox(){
        checkBoxes.checkCheckBox1();
    }

    @Test
    public void verifySecondCheckBoxIsChecked(){
        boolean checkBox2IsChecked = checkBoxes.isCheckBox2Checked();
        Assert.assertTrue(checkBox2IsChecked);
    }

    @AfterClass
    public void afterClass(){
        BrowserFactory.quitDriver();
    }
}
