package Day09_BasicAuthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void newWindowHandleTest(){
        // 1. Techpro education sayfasina gidelim
        driver.get("https://www.techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        // 2. sayfanin title'ni "Techpro Education" icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        // 3. yeni bir window acip Amazon'a gidelim
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);// yeni window olusturup oraya gecis yapar
        driver.get("https://www.amazon.com");
        // 4. Amazon sayfasinin title'ni "Amazon" icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        waitFor(3);
        // 5. yeni window da Linkldn gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        // 6. Linkldn sayfasinin title'nin "LinkedIn" icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        waitFor(3);

        // Driver nerede? --> LinkedIn
        // Techpro sayfasina gitmek icin tekrar driver.switchTo().window(techProHandle)
    driver.switchTo().window(techProHandle);

    }
}
