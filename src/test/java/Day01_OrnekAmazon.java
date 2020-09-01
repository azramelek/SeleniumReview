import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {

    // 1. Amazon.com'a gideceğiz.
// 2. Arama kutusuna "baby stroller"
// 3. 2. Sıradaki ürüne tıklayacağız.
// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
// 5. Ürünün ortalama puanını (5 üzerinden) alacağız.

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://amazon.com/");

        driver.manage().window().maximize();
        // 2. Arama kutusuna "baby stroller"
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller" + Keys.ENTER);

//        WebElement element = driver.findElement(By.linkText("Baby Trend Expedition Jogger Stroller, Phantom, 50 Pounds"));
//        element.click();
//        WebElement toplamPuan = driver.findElement(By.id("acrCustomerReviewText"));
//        System.out.println(toplamPuan.getText());


        // 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
        WebElement toplamFiyat = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base']"));
        System.out.println(toplamFiyat.getText());

    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        WebElement searchGoogle = driver.findElement(By.xpath("//input[@name='q']"));
        searchGoogle.sendKeys("Kemal Ozden"+Keys.ENTER);
        WebElement toplamSayi = driver.findElement(By.id("result-stats"));
        System.out.println(toplamSayi.getText());

    }
}
