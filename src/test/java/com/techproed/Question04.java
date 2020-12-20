package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
www.bestbuy.com'a gidin
 Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
 logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
  mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
 */

public class Question04 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){

    }

    @Test
    public void test2(){

    }


    @AfterClass
    public static void tearDown(){
       // driver.quit();
    }

}
