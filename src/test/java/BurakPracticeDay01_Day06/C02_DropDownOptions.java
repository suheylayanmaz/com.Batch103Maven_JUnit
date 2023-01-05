package BurakPracticeDay01_Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {
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
    // @Test
    public void test() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");
        // dropdown'dan "Books" secenegini secin
        // dropdown'dan "Baby" secenegini secin
        WebElement searcbox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select searchDropdownBox = new Select(searcbox);
        searchDropdownBox.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String sectiginizOption = searchDropdownBox.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option : " + sectiginizOption);
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptionList = searchDropdownBox.getOptions();
        int actualOptionCount = tumOptionList.size();
        int expectedOptionCount = 28;
        Assert.assertEquals(actualOptionCount, expectedOptionCount);
    }
    }
