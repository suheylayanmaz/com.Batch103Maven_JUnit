package Day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class C07_Assertion {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }
    //2)https://amazon.com adresine gidin
    //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
    //            ○ title Test  => Sayfa başlığının “Amazon” oldugunu test edin
    //            ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    //            ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    //            ○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin
    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void imageTest() {
        WebElement actualImage = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(actualImage.isDisplayed());
    }
    @Test
    public void searchBoxTest() {
        WebElement actualSearchBox = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        Assert.assertTrue(actualSearchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest() {
        String actualTitle = driver.getTitle();
        String expectedWrongTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedWrongTitle));
    }
}
