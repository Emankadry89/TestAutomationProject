package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    WebDriver driver;

    //Variables
    String url = "https://jqueryui.com/resources/demos/droppable/default.html";

    //Constructor
    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    By dragBox = By.id("draggable");
    By dropBox = By.id("droppable");
    By droppedMessage = By.xpath("//div[@id='droppable']/p");

    //Methods
    public void openDragDropPage(){
        driver.navigate().to(url);
    }

    public void dragAndDropTheBox(){
        Actions action = new Actions(driver);
        WebElement drag = driver.findElement(dragBox);
        WebElement drop = driver.findElement(dropBox);
        action.dragAndDrop(drag, drop).perform();
    }

    public String getDropBoxText(){
       return driver.findElement(droppedMessage).getText();
    }
}
