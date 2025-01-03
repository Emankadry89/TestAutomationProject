package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DuckduckgoHomePage {

    WebDriver driver;

    //variables
    String url = "https://duckduckgo.com/";

    //Locators
    By pageLogo = By.xpath("//section[@class='header_headerLeft__gTUAg header_headerSection__C99zW']/a/img");
    By searchBar = By.xpath("//input[@class='searchbox_input__bEGm3']");

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
