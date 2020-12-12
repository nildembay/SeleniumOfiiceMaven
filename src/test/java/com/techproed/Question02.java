package com.techproed;
/*
BeforeClass ile driver ı oluşturun.
Maximize edin, 10 sn bekletin
AfterClass ile kapatın
Google'a gidin
1. olarak zoom 'u aratıp çıkan sonuç sayısını ekrana yazdırın
2. olarak Selenium 'u aratıp çıkan sonu sayısını ekrana yazdırın.
3. olarak Techproeducation'u aratıp çıkan sonuç sayısını ekrana yazdırın.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question02 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Before
    public void get1() {
        driver.get("https://www.google.com");
    }
    @Test
    public void test1() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("zoom"+ Keys.ENTER);
    }
    @Test
    public void test2() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium"+Keys.ENTER);

    }

    @Test
    public void test3() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Techproeducation"+Keys.ENTER);

    }
    @After
    public void afterson(){
        WebElement sonucYazisi=driver.findElement(By.id("result-stats"));
        System.out.println(sonucYazisi.getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



}
