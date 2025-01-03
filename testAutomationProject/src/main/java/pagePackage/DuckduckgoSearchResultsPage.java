package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuckduckgoSearchResultsPage {

    WebDriver driver;

    //Locators
    By firstSearchResultLink = By.xpath("//article[@id='r1-0']/div/h2/a");


    //Constructor
    public DuckduckgoSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public String getFirstResultLink() {
        return driver.findElement(firstSearchResultLink).getDomAttribute("href");

    }
}