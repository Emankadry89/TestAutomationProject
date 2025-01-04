package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.CheckBoxesPage;
import pagePackage.FileUploadedPage;
import pagePackage.UploadFilePage;

public class UploadFileTests {

    WebDriver driver;
    UploadFilePage file;
    FileUploadedPage message;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        file = new UploadFilePage(driver);
        message = new FileUploadedPage(driver);
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
        Assert.assertEquals(successMessage, "File Uploaded!");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
