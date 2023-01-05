package ErolPractice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P01 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //    go to url :https://demo.automationtesting.in/Alerts.html
        driver.get("https://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText()); // Alert uzerindeki yaziyi konsola yazdirdik
        driver.switchTo().alert().accept();

        // 2. yol
        // driver.findElement(By.className("analystic")).sendKeys(Keys.ENTER,Keys.TAB, Keys.TAB,Keys.TAB,Keys.ENTER);



        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[.='Alert with Textbox ']")).click();
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Thread.sleep(2000);
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //    finally print on console this message "Hello TechproEducation How are you today"
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());
        //    aseertion these message
        Assert.assertEquals("Hello TechProEducation How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());
    }

}
