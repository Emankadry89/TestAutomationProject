package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {

    //Variables
    private final WebDriver driver;
    private final String url = "https://jqueryui.com/resources/demos/droppable/default.html";

    //Constructor
    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private final By dragBox = By.id("draggable");
    private final By dropBox = By.id("droppable");
    private final By droppedMessage = By.xpath("//div[@id='droppable']/p");

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
