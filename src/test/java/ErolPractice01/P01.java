package ErolPractice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {


    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test01() throws InterruptedException {
        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com/");
        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        //-title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
        String actuelTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        String arananKelime = "Spend";
        Assert.assertFalse(actuelTitle.contains(arananKelime)
                && actualUrl.contains(arananKelime));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com/");
        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actuelTitle1 = driver.getTitle();
        String actualUrl1 = driver.getCurrentUrl();
        String arananKelime1 = "Sitesi";
        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        Assert.assertFalse(actualUrl1.contains(arananKelime1)
            && actuelTitle1.contains(arananKelime1));
        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(2000);
        //-sayfayi yenileyelim
        driver.navigate().refresh();
        Thread.sleep(2000);
        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}



