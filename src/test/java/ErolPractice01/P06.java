package ErolPractice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");
        /*WebElement cookies = driver.findElement(By.id("gdpr-banner-accept"));
        cookies.click();*/
        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//li[@class='hl-cat-nav__js-tab'])[1]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        for (int i = 1; i < 28; i++) {
            List<WebElement> imgages = driver.findElements(By.cssSelector("//*[@width='225' and @height='225']"));
            imgages.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+ " baslik " +driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        }
        //- Her sayfanın sayfa başlığını yazdıralım
        //- sayfayı kapatalım

    }
}
