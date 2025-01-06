package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.DragAndDropPage;
import utils.JsonReader;

import java.io.IOException;
import java.util.Map;

public class DragAndDropTests {

    WebDriver driver;
    DragAndDropPage box;
    Map<String, String> testData;

    @BeforeClass
    public void beforeClass() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        box = new DragAndDropPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/dragDropData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        box.openDragDropPage();
    }

    @Test
    public void dragAndDropBox() {
        box.dragAndDropTheBox();
        String text = box.getDropBoxText();
        String expectedMessage = testData.get("expectedMessage");
        Assert.assertEquals(text, expectedMessage);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
