package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DuckduckgoSearchResultsPage {

    private final WebDriver driver;

    //Locators
    private By firstSearchResultLink ;
    private By forthSearchResultTitle ;
    private final By moreResultsButton = By.id("more-results");
    private By secondPageSecondSearchResultLink ;


    //Constructor
    public DuckduckgoSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public String getFirstResultLink(int resultNumber) {
        firstSearchResultLink = By.xpath("(//li[@data-layout='organic'])["+resultNumber+"]//a[@data-testid='result-title-a']");
        return driver.findElement(firstSearchResultLink).getDomAttribute("href");

    }

    public String getForthResultTitle(int resultNumber){
        forthSearchResultTitle = By.xpath("(//li[@data-layout='organic'])["+resultNumber+"]//a[@data-testid='result-title-a']");
        return driver.findElement(forthSearchResultTitle).getText();
    }

    public String getSecondPageSecondResultLink(int resultNumber) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(moreResultsButton).click();
        secondPageSecondSearchResultLink = By.xpath("(//li[@data-layout='organic'])["+resultNumber+"]//a[@data-testid='result-title-a']");
        return driver.findElement(secondPageSecondSearchResultLink).getDomAttribute("href");

    }
}
