package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxesPage {

    //Variables
    private final WebDriver driver;
    private final String url = "http://the-internet.herokuapp.com/checkboxes";

    //Constructor
    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By checkbox1 = By.xpath("//input[1]");
    private final By checkbox2 = By.xpath("//input[2]");

    //Methods
    public void openCheckBoxesPage() {

        driver.navigate().to(url);
    }

    public void checkCheckBox1() {
        driver.findElement(checkbox1).click();
    }

    public boolean isCheckBox2Checked() {
        return driver.findElement(checkbox2).isSelected();
    }
}
