package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DuckduckgoSearchResultsPage {

    WebDriver driver;

    //Locators
    By firstSearchResultLink = By.xpath("//article[@id='r1-0']/div/h2/a");
    By forthSearchResultTitle = By.xpath("//article[@id='r1-3']/div/h2/a/span");


    //Constructor
    public DuckduckgoSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public String getFirstResultLink() {
        return driver.findElement(firstSearchResultLink).getDomAttribute("href");

    }

    public String getForthResultTitle(){
        return driver.findElement(forthSearchResultTitle).getText();
    }

    public boolean isForthResultTitleDisplayed(){
        return driver.findElement(forthSearchResultTitle).isDisplayed();
    }
}
