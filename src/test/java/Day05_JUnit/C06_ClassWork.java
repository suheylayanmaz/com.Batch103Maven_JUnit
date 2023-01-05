package Day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        //Cookies’i kabul edin
        driver.findElement(By.xpath("(//*[@type='submit'])[3]")).click();

        //“Create an Account” button’una basin

       driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();



        /*
        <a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy" href="#" ajaxify="/reg/spotlight/"
        id="u_0_0_hS" data-testid="open-registration-form-button" rel="async">Yeni Hesap Oluştur</a>
         */
        //“radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("(//*[@class='_8esa'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//*[@class='_8esa'])[2]"));
        WebElement custom = driver.findElement(By.xpath("(//*[@class='_8esa'])[3]"));

        if(!male.isSelected()){
            male.click();
        }
        Thread.sleep(3000);
        female.click();
        Thread.sleep(3000);
        custom.click();
        //Secili degilse cinsiyet butonundan size uygun olani secin
    }
}
