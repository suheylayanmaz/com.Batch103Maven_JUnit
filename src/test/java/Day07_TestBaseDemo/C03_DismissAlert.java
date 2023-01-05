package Day07_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    @Test
    public void dismissAlert() throws InterruptedException {
        // 2. butona tıklayın,
        // uyarıdaki Cancel butonuna tıklayın
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver
                .switchTo()
                .alert()
                .dismiss();
        // ve result mesajının “You clicked: Cancel”
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You clicked: Cancel";
        // oldugunu test edin.
        Assert.assertEquals(expectedResult, actualResult);

    }
}
