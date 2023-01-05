package BurakPracticeDay01_Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @After
    public void tearDown() {
       // driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        Thread.sleep(3000);
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(frame1);
        WebElement cookies = driver.findElement(By.xpath("//*[.='Tümünü Kabul Et']"));
        cookies.click();
        Thread.sleep(3000);
        // checkbox elementlerini locate edin
        WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
        Thread.sleep(3000);
        WebElement checkbox2 = driver.findElement(By.id("vfb-6-1"));
        Thread.sleep(3000);
        WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));
        Thread.sleep(3000);

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        Thread.sleep(3000);
        if (!checkbox3.isSelected()){
            checkbox3.click();
        }
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkbox1.isSelected());
        Thread.sleep(3000);
        Assert.assertTrue(checkbox3.isSelected());
        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkbox2.isSelected());
    }
}
