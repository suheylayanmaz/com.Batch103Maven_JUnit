package ErolPractice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void setup() {
        driver.get("http://www.google.com");
        WebElement cookies = driver.findElement(By.xpath("//*[@id='L2AGLb']"));
        cookies.click();
    }
    @Test
    public void test01() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The Got Father", Keys.ENTER);
    }
    @Test
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void test03() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);
    }

    @After
    public void teardown() {
        String [] aramaResults = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Results = " + aramaResults[1]);
        //driver.quit();
    }
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }


        //BeforeClass ile driver ı olusturun ve
        //Maximize edin, 15 sn bekletin
        //http://www.google.com adresine gidin
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        //AfterClass ile kapatın
    }

