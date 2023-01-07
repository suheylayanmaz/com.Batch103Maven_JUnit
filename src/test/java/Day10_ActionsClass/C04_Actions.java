package Day10_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    @Test
    public void dragAndDropTest(){
        //Class: Action4
        //Method: dragAndDropTest
        //Given user is on https://jqueryui.com/droppable/
        //And user moves the target
        // element(Drag me to my target) in to  destination(Drop here)
        driver.get("https://jqueryui.com/droppable");
        //Elementler iframe in icinde
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak, hedef).perform();

    }
    // 2. yol
    @Test
    public void clickAndHoldTest(){
        driver.get("https://jqueryui.com/droppable");
        //Elementler iframe in icinde
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak)
                .moveToElement(hedef)
                .build()//iki islemin birbiriyle baglantisini kurar
                .perform();
    }

    @Test
    public void moveByOffSet(){
        driver.get("https://jqueryui.com/droppable");
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)
                .moveByOffset(430, 30)
                .release()
                .build()
                .perform();
    }

}
