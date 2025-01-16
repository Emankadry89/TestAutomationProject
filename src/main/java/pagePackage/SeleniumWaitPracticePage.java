package pagePackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumWaitPracticePage {

    //Variables
    private final WebDriver driver;
    private final String url = "https://www.selenium.dev/selenium/web/dynamic.html";

    //constructor
    public SeleniumWaitPracticePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By addBox = By.id("adder");
    private final By redBox = By.id("box0");

    //Methods
    public void navigate() {
        driver.navigate().to(url);
    }

    public void clickOnAddBox() {
        driver.findElement(addBox).click();
    }

    public boolean verifyRedBoxDisplay() {
        return driver.findElement(redBox).isDisplayed();
    }
}
