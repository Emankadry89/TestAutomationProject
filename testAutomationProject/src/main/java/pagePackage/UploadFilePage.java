package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.nio.file.Paths;

public class UploadFilePage {

    WebDriver driver;

    //Variable
    String url = "http://the-internet.herokuapp.com/upload";

    //Constructor
    public UploadFilePage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    By fileUploadButton = By.id("file-upload");
    By fileSubmitButton = By.id("file-submit");

    //Methods
    public void openUploadFilePage(){
        driver.navigate().to(url);
    }

    public void uploadFile(String fileName) {
        String filePath = getAbsolutePath("images/" + fileName);
        driver.findElement(fileUploadButton).sendKeys(filePath);
    }

    private String getAbsolutePath(String relativePath) {
        try {
            URL resource = getClass().getClassLoader().getResource(relativePath);
            if (resource == null) {
                throw new IllegalArgumentException("File not found: " + relativePath);
            }
            return Paths.get(resource.toURI()).toFile().getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get file path for: " + relativePath, e);
        }
    }

    public void submitFile(){
        driver.findElement(fileSubmitButton).click();
    }
}
