package Day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_RelativeLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        // sayfadaki Berlin WE'ini relative locator ile tiklayin.
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //driver.findElement(By.id("btnG")).click();

        WebElement BayAreaWE = driver.findElement(By.xpath("//*[@id='pid8_thumb']"));
        WebElement NewYorkCityWE = driver.findElement(By.xpath("//*[@id='pid3_thumb']"));
        WebElement BerlinWE = driver.findElement(with(By.tagName("li")).below(NewYorkCityWE).toLeftOf(BayAreaWE));
        BerlinWE.click();

    }
}
