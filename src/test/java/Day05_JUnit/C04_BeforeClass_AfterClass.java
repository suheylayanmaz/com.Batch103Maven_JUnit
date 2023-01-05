package Day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class C04_BeforeClass_AfterClass {
    /*
    @BeforeClass ve @AfterClass method'lari sadece
    static method'lar icin kullanilir.
    @BeforeClass ve @AfterClass method'larini kullanirsak
    olusturdugumuz test method'larinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After notasyonlarini kullanirsak her @Test ten once
    bir kez @Before ve @After calismis olur.

     */
    @BeforeClass
    public static void setup() {
        System.out.println("Butun testlerden once @BeforeClass calisti.");
    }
    @Before
    public void setup01() {
        System.out.println("Her testten once bir kere @Before calisir.");;
    }
    @AfterClass
    public static void tearDown01() {
        System.out.println("Her testten sonra birkere @After calisir.");
    }
    @AfterClass
    public static void tearDown() {
        System.out.println("Tum testlerden sonra @AfterClass calisti.");
    }
    @Test
    public void test01(){
        System.out.println("Test01 calisti.");
    }
    @Test
    public void test02(){
        System.out.println("Test02 calisti.");
    }
    @Test
    @Ignore
    public void test03(){
        System.out.println("Test03 calisti.");
    }
    /*
    @Ignore notasyonu eklendigi testin ignore edilmesini saglar.
     */

}
