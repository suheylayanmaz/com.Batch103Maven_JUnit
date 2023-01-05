package Day07_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {

    @Test
    public void PromtAlert() throws InterruptedException {
        ////3. butona tıklayın,
        // uyarıdaki metin kutusuna isminizi yazin,
        // OK butonuna tıklayın ve result
        // mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        driver
                .switchTo()
                .alert()
                .sendKeys("Suheyla");
        Thread.sleep(2000);
                driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "Suheyla";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }


}
