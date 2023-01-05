package Day07_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
    UTILITIES:
    1) Tekrar tekrar kullanacagimiz class'lari veya method'lari
    koydugumuz paketin adidir.
            - TestBaseErol BUGUN
            - Driver    sonra
            - ExcelUtil sonra
            - Configuration sonra
      2) UTILITIES paketinde tets case'ler yazilmaz. Sadece support class'lari
      yani tekrar kullanacagimiz destek siniflari konulur.

      3) Bu support classlar test case'lerin daha hizli calismasini saglar.

     */
    @Test
    public void test() {
        // techproeducation ana sayfasina git
        // ve title'in 'Bootcamps' kelimesini icerdigini test edelim.
        driver.get("https://www.techproeducation.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamps"));
    }
}
