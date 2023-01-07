package Day10_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test(){
        //Class: ActionClass3
        //Method : scrollUpDown()
        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");
        Actions actions = new Actions(driver);
        //Sayfanin altına doğru gidelim
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        //Sonra sayfanın üstüne doğru gidelim

        actions.sendKeys(Keys.ARROW_DOWN).perform();//pagedown dan daha az gider
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.DOWN).perform();

    }
}
