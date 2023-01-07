package Day10_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void test(){
        //Class: Actions2
        //Method : hoverOver() and test the following scenario:
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
        Actions actions = new Actions(driver);
        WebElement count = driver.findElement(By.xpath("(//*[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(count).perform();
        waitFor(2);

        //“Account” secenegine tikka
        WebElement yourCount = driver.findElement(By.xpath("(//*[@class='nav-text'])[4]"));
        waitFor(2);
        actions.doubleClick(yourCount).perform();
        //driver.findElement(By.linkText("Account")).click();
        waitFor(2);
        switchToWindow("https://www.amazon.com/gp/css/homepage.html?ref_=nav_AccountFlyout_ya");
        //Acilan sayfanin Title in “Your Account” icerdigini dogrula

        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
