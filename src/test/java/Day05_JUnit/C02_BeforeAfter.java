package Day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setup() {
        System.out.println("before natosyonu her test metodundan once calisir");
    }
    @After
    public void tearDown() {
        System.out.println("after natosyonu her test metodundan sonra calisir");
    }
    @Test
    public void test01() {
        System.out.println("ilk test");
    }
    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
    /*
    before natosyonu her test metodundan once calisir
    ilk test
    after natosyonu her test metodundan sonra calisir
    before natosyonu her test metodundan once calisir
    ikinci test
    after natosyonu her test metodundan sonra calisir
     */
}
