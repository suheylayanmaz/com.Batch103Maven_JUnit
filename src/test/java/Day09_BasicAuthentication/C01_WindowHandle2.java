package Day09_BasicAuthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase{
    @Test
    public void testWindowHandle(){
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindowsText = driver.findElement(By.xpath("//h3")).getText();
        String expectedWindowsText = "Opening a new window";
        Assert.assertEquals(expectedWindowsText, actualWindowsText);

        String window1Handle = driver.getWindowHandle();
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindow1Title = driver.getTitle();
        String expectedWindow1Title = "The Internet";
        Assert.assertEquals(actualWindow1Title, expectedWindow1Title);
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        waitFor(3);
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // 2. pencerede islem yapmak istedigim icin o pencereye switchTo() yapmaliyiz.
        //switchToWindow(1);
        //veya
        switchToWindow("New Window");
        //veya
        //switchToWindow_URL();
        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
    }


}
