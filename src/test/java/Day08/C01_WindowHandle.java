package Day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {
    @Test
    public void testWindowHandle() throws InterruptedException {
        //Tests package'inda yeni bir class olusturun: WindowHandle
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // bu sayfanin id sini alalim
        String window1Handle = driver.getWindowHandle();
        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String windowText = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals("Opening a new window", windowText);
        ////Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String pageTitle = driver.getTitle();
        Assert.assertEquals("The Internet", pageTitle);
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        Thread.sleep(3000);
        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.

        Set<String> allWindowsHandles = driver.getWindowHandles();
        System.out.println(allWindowsHandles);
        for (String eachHandle : allWindowsHandles){
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);
                break;
            }
             /*
        LAMBDA
         Set<String> tumPencereler= driver.getWindowHandles();//buradan iki tane handle gelecek
            tumPencereler.stream().filter(t->!t.equals(handle1)).forEach(t->driver.switchTo().window(t));
         */
        }
        // BURADA 2. SAYFADAYIM

        Assert.assertEquals("New Window", driver.getTitle());

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());

        String window2Handle = driver.getWindowHandle();
        //    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(3000);
        //    1. windowa gecis yapiyorum
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());

        Thread.sleep(3000);
//        2. windowa tekrar gecelim
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
//        1. windowa tekrar gecelim
        driver.switchTo().window(window1Handle);




        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.


    }



}
