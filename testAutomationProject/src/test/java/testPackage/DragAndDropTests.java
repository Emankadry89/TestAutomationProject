package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagePackage.DragAndDropPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class DragAndDropTests {

    WebDriver driver;
    DragAndDropPage box;
    Map<String, String> testData;

    @BeforeMethod
    public void setup() throws IOException {
        URL gridUrl = new URL("http://localhost:4444");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl, chromeOptions);
        driver.manage().window().maximize();
        box = new DragAndDropPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/dragDropData.json");
        box.openDragDropPage();
    }

    @Test
    public void dragAndDropBox() {
        box.dragAndDropTheBox();
        String text = box.getDropBoxText();
        String expectedMessage = testData.get("expectedMessage");
        Assert.assertEquals(text, expectedMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
