package com.techproed;



/*
Google'a gidelim
LOgosunun görünüp görünmediğini assert edelim
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question05 {

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
        WebElement logo=driver.findElement(By.id("hplogo"));
        Assert.assertTrue(logo.isDisplayed());



    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
