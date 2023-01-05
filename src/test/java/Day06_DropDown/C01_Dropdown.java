package Day06_DropDown;

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

public class C01_Dropdown {
    //https://the-internet.herokuapp.com/dropdown
    //https://the-internet.herokuapp.com/dropdown
    //https://testcenter.techproeducation.com/index.php?page=dropdown
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void selectByIndexTest() {
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // dogum yilini, ayini ve gununu su sekilde secer : 2000, January, 10
        // 1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        // 2. SELECT objesi olustur
        Select yearDropdown = new Select(year);
        // 3. SELECT objesini kullanarak 3 farkli sekilde secim yapalim
        yearDropdown.selectByIndex(22);// secenek sirasi 0 dan baslar 200 uili 23. sirada
                // Ay secimi
        WebElement month = driver.findElement(By.id("month"));
        Select monthDropdown = new Select(month);
        monthDropdown.selectByValue("0");// option in value degeri ile secim yapilabilir. January seceneginin value si 0

                // Gun secimi
        WebElement day = driver.findElement((By.id("day")));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");// Case sensitive

    }
    @Test
    public void printAllTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Tum eyalet isimlerini konsola yazdir.
        WebElement state = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
        for (WebElement w : stateList) {
            System.out.println(w.getText());
        }
        // Lambda ile
        //stateList.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionsTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // State dropdown daki var sayilan secili elementin Select  a State oldugunu verify edin.
        WebElement state = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(state);

        //WebElement varsayilanElement = stateDropdown.getFirstSelectedOption();
        //String varsayilanElementText = varsayilanElement.getText();
        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", varsayilanText);

    }

    @After
    public void tearDown() {

        driver.close();
    }
    /*
    1.What is the dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.
    2. How to handle dropdown elements? Dropdown nasil otomate edilir.
            a. Dropdown'i locate ederim
            b. Select objesi olustururum
            c. Select objesi ile istedigim secenegi secerim.
            Not: Select objesi olusturmamin sebebi, dropdown'larin Select classi ile olusturulmasi
     3. Tum dropdown seceneklerini nasil print ederiz?
            a. Tum dropdown elementlerini getOptions() method'u ile listeye koyariz
            b. Sonra secenekleri loop ile olusturabiliriz.
     4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
     ornek : Gun olarak 10 i sectik ama ya secilmediyse?
     getFirstSelectedOption() secili elementi getirir.

     */
}
