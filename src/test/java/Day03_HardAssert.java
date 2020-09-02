import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {


    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void test() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        // contains - bir string ifadenin içerisinde diğer bir string ifadenin
        //            geçip geçmediğini kontrol ediyordu.
        // "Merhaba Dünya !" -> contains("Dünya") TRUE FALSE

        if (baslik.contains("car")) { // TRUE ya da FALSE
            System.out.println("GEÇİYOR : " + baslik);
        } else {
            System.out.println("GEÇMİYOR : " + baslik);


        }
        boolean iceriyormu = baslik.contains("car");
        Assert.assertTrue(iceriyormu);
    }

    @Test
    public void test2() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        // Sayfa başlığında Google kelimesinin geçmemesi durumunu kontrol ediyor.
        // Eğer GOOGLE kelimesi yoksa TEST BAŞARILI.
        // Eğer GOOGLE kelimesi varsa TEST BAŞARISIZ.

        boolean falseMu = baslik.contains("Google");
        Assert.assertFalse(baslik.contains("Google"));

    }

    @Test
    public void test3() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        Assert.assertEquals("Amazon.com", baslik);

    }

    @Test
    public void softAssertTest() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();


    }
}