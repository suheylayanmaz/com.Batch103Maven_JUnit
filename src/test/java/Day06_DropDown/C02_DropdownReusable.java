package Day06_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    // REUSABLE METHOD : Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim.
    @Test
    public void selectFromDropdown(WebElement dropdown, String secenek) {
        // selectFromDropdown(driver.findElement(By.id("year")), "2005");
        // selectFromDropdown(driver.findElement(By.id("month")), "January");
        // selectFromDropdown(driver.findElement(By.id("day")), "12");

        // gonderilen tum webelementlerin tum options lari alinir.
        List<WebElement> options = dropdown.findElements(By.tagName("option")); // Tum option tagli elementleri gonderir.
        for (WebElement eachOption : options) {
            if (eachOption.getText().equals(secenek)) {
                eachOption.click();
                break;
            }
        }

    }
    @Test
    public void selectFromDropdown() {

        selectFromDropdown(driver.findElement(By.xpath("//*[@id='year']")), "2005" );
        selectFromDropdown(driver.findElement(By.id("month")),  "November");
        selectFromDropdown(driver.findElement(By.id("day")), "10" );
    }
    // Not: sonraki ders tekrar ve kullanisi
}
