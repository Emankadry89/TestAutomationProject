package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadedPage {
    WebDriver driver;

    //Constructor
    public FileUploadedPage(WebDriver driver){
        this.driver =driver;
    }

    //Locators
    By fileUploadedMessage = By.tagName("h3");

    //Methods
    public String getUploadedMessage(){
        return driver.findElement(fileUploadedMessage).getText();
    }
}
