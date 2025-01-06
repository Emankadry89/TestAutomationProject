package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.FileUploadedPage;
import pagePackage.UploadFilePage;
import utils.JsonReader;

import java.io.IOException;
import java.util.Map;

public class UploadFileTests {

    WebDriver driver;
    UploadFilePage file;
    FileUploadedPage message;
    Map<String, String> testData;

    @BeforeClass
    public void beforeClass() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        file = new UploadFilePage(driver);
        message = new FileUploadedPage(driver);
        testData = JsonReader.readJson("src/test/resources/testData/uploadFileData.json");
    }

    @BeforeMethod
    public void beforeMethod(){
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

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
