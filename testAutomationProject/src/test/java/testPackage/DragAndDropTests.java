package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DragAndDropPage;

public class DragAndDropTests {

    WebDriver driver;
    DragAndDropPage box;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        box = new DragAndDropPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        box.openDragDropPage();
    }

    @Test
    public void dragAndDropBox() {
        box.dragAndDropTheBox();
        String text = box.getDropBoxText();
        Assert.assertEquals(text, "Dropped!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
