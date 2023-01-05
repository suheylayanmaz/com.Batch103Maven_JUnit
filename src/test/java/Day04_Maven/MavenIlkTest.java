package Day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
        //2arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //3"Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //4Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu : " + sonucSayisi.getText());

        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();
        //List<WebElement> urunler =
        //6Sayfadaki tum basliklari yazdiralim
        List<WebElement> h1Listesi = (List<WebElement>) driver.findElements(By.xpath("//h1"));
        for (WebElement w : h1Listesi){
            System.out.println(w.getText());
        }
        h1Listesi.forEach(t-> System.out.println(t.getText()));
        System.out.println("***  "+driver.findElement(By.xpath("//h1")).getText());
        //System.out.println("**  "+driver.findElement(By.xpath("//h2")).getText());
        //System.out.println("*  "+driver.findElement(By.xpath("//h1")).getText());
        driver.close();
    }
}
