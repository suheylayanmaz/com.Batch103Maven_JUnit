package ErolPractice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("https://demo.guru99.com/test/guru99home/");
        WebElement frame1 = driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(frame1);
        WebElement cookies = driver.findElement(By.xpath("//*[.='Tümünü Kabul Et']"));
        cookies.click();
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe Sayisi = "+iframe.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame2 = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        Thread.sleep(3000);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.navigate().refresh();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }
    }
