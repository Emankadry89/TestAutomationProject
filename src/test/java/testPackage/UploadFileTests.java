package testPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.FileUploadedPage;
import pagePackage.UploadFilePage;
import testBase.TestBase;
import utils.JsonReader;
import java.io.IOException;
import java.util.Map;

public class UploadFileTests extends TestBase {

    UploadFilePage file;
    FileUploadedPage message;
    Map<String, String> testData;

    @BeforeMethod
    public void setup() throws IOException {
        file = new UploadFilePage(driver);
        message = new FileUploadedPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/uploadFileData.json");
        file.openUploadFilePage();
    }

    @Test
    public void uploadFile(){
        file.uploadFile("ladybug.jpeg");
        file.submitFile();
        String successMessage = message.getUploadedMessage();
        String expectedMessage = testData.get("expectedMessage");
        Assert.assertEquals(successMessage, expectedMessage);
    }
}
