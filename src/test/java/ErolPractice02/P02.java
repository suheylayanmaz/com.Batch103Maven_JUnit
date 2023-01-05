package ErolPractice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//img"));
        emojiler.stream().forEach(t->t.click()); // Lambda ile tüm webelementlere tıkladık
        //for (WebElement w:emojiler) {
        //    w.click();
        //}

        // parent iframe e geri donun


        // parent iframe e geri donun
        driver.switchTo().parentFrame();
        //veya driver.switchTo().defaultContent();
        //veya driver.navigate().refresh();



        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));

        List<String> veriler = new ArrayList<>(Arrays.asList("Suheyla","Yanmaz","Java","Selenium",
                "Lambda","Githup","API","SQL","STLC","SDLC","ManualTesting"));
        // Keys.TAB ile de yapilabilir
        for(int i = 0; i < list.size(); i++){
            list.get(i).sendKeys(veriler.get(i));
        }
        //  apply button a basin
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}
