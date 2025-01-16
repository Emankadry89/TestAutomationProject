package testPackage;

import org.testng.Assert;
import org.testng.annotations.*;
import pagePackage.DragAndDropPage;
import testBase.TestBase;
import utils.JsonReader;
import java.io.IOException;
import java.util.Map;

public class DragAndDropTests extends TestBase {

    DragAndDropPage box;
    Map<String, String> testData;

    @BeforeMethod
    public void setup() throws IOException {
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
}
