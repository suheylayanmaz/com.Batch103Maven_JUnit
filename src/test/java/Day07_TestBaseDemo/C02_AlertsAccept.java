package Day07_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {
    @Test
    public void acceptAlertTest() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        // 1. butona tiklayiniz
        // uyaridaki OK butonuna tiklayin

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver
                .switchTo()
                .alert()
                .accept();// OK secenegine tiklar.
        // ve result mesajinin
        // "You succesfully clicked an alert" oldugunu test edin.

        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);
        }
}
