package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3SchoolTablePage {

    //Variables
    private final WebDriver driver;
    private final String url = "https://www.w3schools.com/html/html_tables.asp";

    //Constructor
    public W3SchoolTablePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By ernstHandelCountry = By.xpath("//tr[td[text()='Ernst Handel']]/td[3]");

    //Methods
    public void navigate() {
        driver.navigate().to(url);
    }

    public String getErnstHandelCountry() {
        return driver.findElement(ernstHandelCountry).getText();
    }

}
