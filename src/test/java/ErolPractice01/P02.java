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

public class P02 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test() {
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement cookies = driver.findElement(By.id("ez-accept-all"));
        cookies.click();
        //fill the firstname//fill the lastname
        //        //check the gender
        //        //check the experience
        //        //fill the date
        //        //choose your profession -> Automation Tester
        //        //choose your tool -> Selenium Webdriver
        //        //choose your continent -> Antartica
        //        //choose your command  -> Browser Commands
        //        //click submit button
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys("Ebrar", //first name
                Keys.TAB,"Ilhan", //last name
                Keys.TAB,Keys.ARROW_RIGHT, //gender (female)
                Keys.TAB,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT, //years of experience
                Keys.TAB,"12/12/2022", //date
                Keys.TAB,Keys.TAB,Keys.SPACE, //profession
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE, //automation tools
                Keys.TAB,"Antartica", //continents
                Keys.TAB,Keys.LEFT_CONTROL,Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE); //selenium commands
        /*
        firstName.sendKeys("Suheyla", Keys.TAB,"Yanmaz",Keys.TAB,Keys.ARROW_RIGHT, Keys.SPACE,
                Keys.TAB,Keys.ARROW_RIGHT,Keys.SPACE, Keys.TAB, "2022/06/22", Keys.TAB, Keys.TAB, Keys.SPACE,
                Keys.TAB, Keys.TAB, Keys.TAB, Keys.SPACE, Keys.TAB, "Africa", Keys.TAB,Keys.LEFT_CONTROL,
                Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE);
                */



    }

}
