package HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class WindowsHandle extends TestBase {
   @Test
    public void test(){
       // https://testcenter.techproeducation.com/index.php?page=multiple-windows
       driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
       String window1 = driver.getWindowHandle();
       //Title in ‘Windows’ oldugunu test edin
       Assert.assertEquals(driver.getTitle(), "Windows");
       //Click here a tiklayin
       driver.findElement(By.linkText("Click Here")).click();
       switchToWindow(1);
       //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
       Assert.assertEquals(driver.getTitle(), "New Window");
   }
}
