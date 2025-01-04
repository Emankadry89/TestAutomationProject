package testPackage;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagePackage.W3SchoolTablePage;

public class W3SchoolTableTest {

    WebDriver driver;
    W3SchoolTablePage table;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0 , 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        table = new W3SchoolTablePage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        table.navigete();
    }

    @Test
    public void verifyErnstHandleCountry(){
        String ernstHandleCountry = table.getErnstHandelCountry();
        Assert.assertEquals(ernstHandleCountry, "Austria");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
