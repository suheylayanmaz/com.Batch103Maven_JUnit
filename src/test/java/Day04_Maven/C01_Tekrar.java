package Day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Amazon sayfasina gidin
        driver.get("https://www.amazon.com/");
        // Arama kutusunu locate edin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@input='twotabsearchtextbox']"));
        // Arama kutusunun tagName'inin input oldugunu test ediniz
        String actualTagname = aramaKutusu.getTagName();
        String expectedTagname = "input";
        if (actualTagname.equals(expectedTagname)){
            System.out.println("Tag name testi PASSED" + actualTagname);
        }else {
            System.out.println("Tag name testi FAILED" + actualTagname);
        }
        // Arama kutusunun name atribute'nun degerinin field-keywords oldugunu test ediniz-
        String actualAttributeName = aramaKutusu.getAttribute("name");
        String expectedName = "field-keywords";
        if (actualAttributeName.equals(expectedName)) {
            System.out.println("Name testi PASSED" + actualAttributeName);

        }else {
            System.out.println("Name testi FAILED" + actualAttributeName);
        }
        // Sayfayi kapatiniz
        driver.close();
    }
}
