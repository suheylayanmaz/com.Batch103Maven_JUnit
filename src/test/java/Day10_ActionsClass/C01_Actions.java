package Day10_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        // 2. Element I Locate edelim
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //Kutuya sag tıklayın
        //Tum actionslar perform() la baslar
        actions.contextClick(kutu).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
        //test edin
        //Tamam diyerek alert’i kapatın
        waitFor(2);
        driver.switchTo().alert().accept();

    }
}
