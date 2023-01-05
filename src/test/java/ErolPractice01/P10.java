package ErolPractice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P10 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");
        //driver.findElement(By.xpath("//button[text()='Accept All']")).click();

        //- electronics bölümüne tıklayınız
        //driver.findElement(By.xpath("(//*[@class='hl-cat-nav__js-tab'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        for (int i = 1; i < 5; i++){
            List<WebElement> urunler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+ ". Baslik : "+ driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
        }
        //- Her sayfanın sayfa başlığını yazdıralım
        //- sayfayı kapatalım
        driver.close();

    }

}
