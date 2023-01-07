package Day09_BasicAuthentication;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void testCookies(){
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(5);
        //1.toplam cookie sayisini bul
        Set<Cookie> cookies = driver.manage().getCookies();
        int cookiesSayisi = cookies.size();
        System.out.println("Cookies sayisi : " + cookies.size());
        //3. Bir Cookie yi smiyle bul
        System.out.println(driver.manage().getCookieNamed("i18n-prefs"));
        // Tum cookieleri yazdiralim
        for (Cookie w : cookies) {
            System.out.println(w);
            System.out.println("------------------");
            System.out.println("Cookies names : " + w.getName());
        }
        System.out.println("------------------");
        cookies.stream().forEach(t -> System.out.println(t.getName()));
        waitFor(2);
        //4. Yeni bir cookie ekle
        Cookie favoriCookim = new Cookie("Cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookim);
        System.out.println("Yeni cookies sayisi : " + driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id-time");
        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("Tum cookies leri sildim");
        System.out.println("Yeni cookie sayisi : " + driver.manage().getCookies().size());
        //Collapse
        //white_check_mark
        //raised_hands
        //pray
    }
}
