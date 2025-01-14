package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DuckduckgoSearchResultsPage {

    WebDriver driver;

    //Locators
    By firstSearchResultLink = By.xpath("//article[@id='r1-0']/div/h2/a");
    By forthSearchResultTitle = By.xpath("//article[@id='r1-4']/div/h2/a/span");
    By moreResultsButton = By.id("more-results");
    By secondPageSecondSearchResultLink = By.xpath("//article[@id='r1-11']/div/h2/a");


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

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void clickMoreResultsButton(){
        driver.findElement(moreResultsButton).click();
    }

    public String getSecondPageSecondResultLink() {
        return driver.findElement(secondPageSecondSearchResultLink).getDomAttribute("href");

    }
}
