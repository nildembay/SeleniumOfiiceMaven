package com.techproed;


/*
@BeforeClass ın içerisinde driver ı kuralım
maximize edip tüm we elementler yüklenene kadar 10 sn bekletelim
Google 'a gidelim ve sayfa başlığının Google içerdiğini doğrulayalım
Amazon'a gidelim ve url in www.amazon.com içerip içermediğini doğrulayalım
@AfterClass ta driver ı kapatalım
 -- From stratch
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question01 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));
    }
    @Test
    public void test2() {
        driver.navigate().to("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));


    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


}
