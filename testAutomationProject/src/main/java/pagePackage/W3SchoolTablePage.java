package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3SchoolTablePage {

    WebDriver driver;

    //Variables
    String url = "https://www.w3schools.com/html/html_tables.asp";

    //Constructor
    public W3SchoolTablePage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    By ernstHandelCountry = By.xpath("//table[@id='customers']/tbody/tr[td[text()='Ernst Handel']]/td[last()]");

    //Methods
    public void navigete(){
        driver.navigate().to(url);
    }

    public String getErnstHandelCountry(){
        return driver.findElement(ernstHandelCountry).getText();
    }

}
