package testPackage;

import org.testng.Assert;
import org.testng.annotations.*;
import pagePackage.CheckBoxesPage;
import testBase.TestBase;

public class CheckBoxesTests extends TestBase {

    private CheckBoxesPage checkBoxes;

    @BeforeMethod
    public void setup() {
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
}
