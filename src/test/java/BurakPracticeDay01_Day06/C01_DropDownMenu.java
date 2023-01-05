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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDownMenu {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
       // driver.close();
    }
    // ...Exercise 1...
    // https://www.amazon.com/ sayfasina gidin
    /*
    // Dropdown 3 adimda handle edilir.

        // 1. Adim: Locate edilmeli.
        WebElement ddMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        // 2. Adim: Select object'i olusturulmali.
        Select select = new Select(ddMenu);

        // 3. Adim: Option secilir.
        select.selectByVisibleText("Books");
         */

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

        // dropdown'dan "Books" secenegini secin
        WebElement searcbox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select searchDropdownBox = new Select(searcbox);
        searchDropdownBox.selectByVisibleText("Books");

        // arama cubuguna "Java" aratın
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        String searchText = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();

       Assert.assertTrue(searchText.contains("Java"));

    }
}
