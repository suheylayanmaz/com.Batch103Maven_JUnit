package ErolPractice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test() throws InterruptedException {
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        // Type any number in the second input
        driver.findElement(By.cssSelector("input[name='number1'"));
        driver.findElement(By.cssSelector("input[name='number2'"));
        // Click on Calculate

        WebElement number = driver.findElement(By.cssSelector("input[name='number1'"));
        number.sendKeys("30",Keys.TAB,Keys.TAB,"20", Keys.ENTER);
        // Print the result
        WebElement result = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println("Sonuc = " + result.getText());
        // close driver
        Thread.sleep(2000);
        driver.close();
    }
}
