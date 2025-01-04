package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.CheckBoxesPage;

public class CheckBoxesTests {

    WebDriver driver;
    CheckBoxesPage checkBoxes;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        driver.quit();
    }
}
