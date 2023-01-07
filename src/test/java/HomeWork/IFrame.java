package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IFrame extends TestBase {

    @Test
    public void IframeOdev() throws InterruptedException {
        //    Bir class olusturun: IframeOdev
        //    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String window1 = driver.getWindowHandle();

        //    sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("Sayfada " + iframe.size() + " tane iframe var");

        waitFor(2);
        // Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        String actuelTitle = driver.findElement(By.xpath("//h3")).getText();
        String expectedTitle = "Editor";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));
        driver.switchTo().frame(0);
        //    Paragrafdaki yaziyi silelim

        WebElement iframeText = driver.findElement(By.xpath("//p"));
        iframeText.clear();

        //    Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        iframeText.sendKeys("Iframe 'in icindeyim.");
        driver.switchTo().window(window1);

        //    Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        String elementSeleniumLinki = driver.findElement(By.linkText("Elemental Selenium")).getText();
        Assert.assertEquals("Elemental Selenium",elementSeleniumLinki);

    }


}
