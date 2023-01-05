package BurakPracticeDay01_Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // radiobutton elementlerini locate edin
        Thread.sleep(3000);
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(frame1);
        WebElement cookies = driver.findElement(By.xpath("//*[.='Tümünü Kabul Et']"));
        cookies.click();
        Thread.sleep(3000);
        WebElement radioButton1 = driver.findElement(By.id("vfb-7-1"));
        radioButton1.click();
        Thread.sleep(3000);
        WebElement radioButton3 = driver.findElement(By.id("vfb-7-3"));

        radioButton3.click();
        WebElement radioButton2 = driver.findElement(By.id("vfb-7-2"));

        Thread.sleep(3000);

        // option2'yi secin
        radioButton2.click();
        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(radioButton2.isSelected());
        // option1 elementinin secili olmadıgını test edin
        Assert.assertFalse(radioButton1.isSelected());
        // option3 elementinin secili olmadıgını test edin
        Assert.assertFalse(radioButton3.isSelected());
    }
}
