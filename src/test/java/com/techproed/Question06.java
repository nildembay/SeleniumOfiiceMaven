package com.techproed;

/*
Amazon'a gidelim,
    Başlığın Amazon içermediğini, Car ve Online içerdiğini kontrol edelim.
    Soft assert kullanalım
    http://a.testaddressbook.com/sign_in adresine gidelim
    mail olarak testtechproed@gmail.com girelim
    Başlığın "Deneme" 'ye eşit olup olmadığını kontrol edelim
    Şifre bölümüne Test1234! i gönderelim
    Title'ın Address book e eşit olup olmadığını assert edelim
    Sign in olalaım
    Ve doğru bir şekilde giriş yapıp yapamadığımızı kontrol edelim
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Question06 {
    WebDriver driver;
    @BeforeClass
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


   @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        String amazonTitle=driver.getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(amazonTitle.contains("Amazon"));
        softAssert.assertFalse(amazonTitle.contains("Car"));
        softAssert.assertTrue(amazonTitle.contains("Online"));

        softAssert.assertAll();

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");
        Thread.sleep(2000);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(driver.getTitle().contains("Deneme"));

        driver.findElement(By.id("session_password")).sendKeys("Test1234!");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Address Book"));

        driver.findElement(By.name("commit")).click();
        WebElement girisYazisi= driver.findElement(By.xpath("//*[text()='Welcome to Address Book']"));
        softAssert.assertTrue(girisYazisi.isDisplayed());
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }



}
