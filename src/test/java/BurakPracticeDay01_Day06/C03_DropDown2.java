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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown2 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown ");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        // dropdown 3 adim ile handle edilir
        // 1. adim locate edilir
        WebElement dde = driver.findElement(By.xpath("//select[@id='dropdown']"));
        // 2. adim Select objesi olusturulur
        Select slct = new Select(dde);
        // 3. adim option secilir
        slct.selectByIndex(1);
        String sectigimOpsiyonIndex = slct.getFirstSelectedOption().getText();
        System.out.println("Sectigim opsiyon index : " + sectigimOpsiyonIndex);
        Thread.sleep(2000);
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        slct.selectByValue("2");
        String sectigimOPsiyonValue = slct.getFirstSelectedOption().getText();
        System.out.println("Sectigim opsiyon value : " + sectigimOPsiyonValue);
        Thread.sleep(2000);
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        slct.selectByVisibleText("Option 1");
        String sectigimOPsiyonVisibleText = slct.getFirstSelectedOption().getText();
        System.out.println("Sectigim opsiyon visible text : " + sectigimOPsiyonVisibleText);
        // Tüm option'ları yazdırın
        Thread.sleep(2000);
        List<WebElement> options = slct.getOptions();// Tum option tagli elementleri
        int sayac = 1;
        for (WebElement w : options) {
            System.out.println(sayac + "" + w.getText());
            sayac++;
        }
        Thread.sleep(2000);
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expectedOptionCount = 3;
        int actualOptionCount = options.size();
        Assert.assertEquals(expectedOptionCount, actualOptionCount);
    }
}
