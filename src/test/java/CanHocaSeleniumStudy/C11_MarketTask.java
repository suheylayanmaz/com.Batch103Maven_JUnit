package CanHocaSeleniumStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C11_MarketTask extends TestBase {
    @Test
    public void test(){
        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        /*Set<Cookie> cookies = driver.manage().getCookies();
        int count = cookies.size();
        System.out.println(count);
        for (Cookie eachCookie : cookies) {
            System.out.println(eachCookie.getName());
            driver.manage().deleteCookie(eachCookie);
        }*/

        //Search iPhone13 512
        WebElement aramaBox = driver.findElement(By.id("twotabsearchtextbox"));
        aramaBox.sendKeys("iPhone13 512", Keys.ENTER);

        //Check that the results are listed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());

        //Click iPhone13 at the top of the list
        //Log the following values for each size .Size information .Price .Color .Stock status
        driver.findElement(By.xpath("//*[@data-image-index='1']")).click();
        String[] productTitle = driver.findElement(By.xpath("//*[@id='title']")).getText().split(" ");
        WebElement productStok = driver.findElement(By.xpath("//*[.='    Stokta var.   ']"));
        //String productPrice = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        String productPrice = driver.findElement(By.xpath("(//*[@class='a-section slots-padding'])[2]")).getText();


        //Isim - Renk - Stok - Boyut - Fiyat
        System.out.println("URUN ISMI : " + productTitle[0] + productTitle[1] + " " + productTitle[2] + "\n"+
                "RENK : " + productTitle[6] + " " + productTitle[7] +"\n"+
                "STOK DURUMU : " + productStok.getText() +"\n"+
                "BOYUT : "  + productTitle[3] + " " + productTitle[4] +"\n"+
                "URUN FIYAT : " + productPrice);


    }
}
