package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DuckduckgoHomePage {

    //variables
    private final WebDriver driver;
    private final String url = "https://duckduckgo.com/";

    //Locators
    private final By pageLogo = By.xpath("//section[not(contains(@class, 'shrink'))]/a/img");
    private final By searchBar = By.xpath("//input[@class='searchbox_input__bEGm3']");

    //Constructor
    public DuckduckgoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void navigate() {
        driver.navigate().to(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(pageLogo).isDisplayed();
    }

    public void searchForQuery(String searchText){
        driver.findElement(searchBar).sendKeys(searchText + Keys.ENTER);
    }


}
