package ErolPractice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHandle extends TestBase {
    @Test
    public void test01(){
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();
        String amazonUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB); // Yeni bir sekme açmış olduk
        //Sayfa title’nin “TECHPROEDUCATION” icerip icermedigini test edin
        driver.get("https://techproeducation.com");
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "TECHPROEDUCATION";
        Assert.assertFalse(actualTitle.contains(expectedTitle1));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //Sayfa title’nin “Walmart” icerip icermedigini test edin
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Walmart";
        Assert.assertFalse(actualTitle2.equals(expectedTitle2));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        Assert.assertEquals(expectedUrl,amazonUrl);
    }

}
