package ErolPractice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



public class P08 {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test(){
        //       https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //       cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

        //       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //       Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //       Bulunan sonuc sayisini yazdirin
        String[] result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");

        //       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String resultText = result[1];
        System.out.println(resultText);
        resultText = resultText.replaceAll("\\D","");
        int resultSayisi = 10000000;
        Assert.assertTrue(Integer.parseInt(resultText)>resultSayisi);
        //       Sayfayi kapatin
        driver.close();
    }


}
