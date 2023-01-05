package ErolPractice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P04 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(iframe);
        //    - youtube videosunu çalıştırınız
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        Thread.sleep(3000);
        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        driver.navigate().refresh();
        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //    - iphone aratınız
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        Thread.sleep(3000);
        String[] sonuc = driver.findElement(By.xpath("//div[@class='sg-col-inner']")).getText().split(" ");

        System.out.println("Arama sonuc yazisi : " + sonuc[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);
        System.out.println("Ilk window url : " + driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım
        driver.close();
        Thread.sleep(3000);
        //    - Sonra diğer sekmeyide kapatalım
        //TestBase deki after notasyonu calisacak

    }
}
