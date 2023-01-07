package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //driver objesini olustur. Driver ya public ya protected olmali.
    //Sebebi child class larda cagirabilmek icin.
    protected static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void teardown() {
       // waitFor(5);
        //driver.quit();
    }
    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }
        //windowNumber sıfır (0)'dan başlıyor.
        public static void switchToWindow(int windowNumber){
            List<String> list = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(list.get(windowNumber));
        }

    /*   HARD WAIT:
@param : second
*/
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/*
    public static void switchToWindow_URL(String url) {
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            if(driver.getCurrentUrl().equals(url)) return;
        }
    }*/

}
