package Day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //C01_TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        // 3- cookies uyarisini kabul ederek kapatin
        //4Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5Arama cubuguna “Nutella” yazip aratin
        //6Bulunan sonuc sayisini yazdirin
        //7sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8Sayfayi kapatin
    }

}
