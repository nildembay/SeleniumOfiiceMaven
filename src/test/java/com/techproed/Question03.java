package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

// 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books seçelim.
// kategorilerin hepsini konsola yazdıralım
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalım.
// 4. Sonuç sayısını ekrana yazdıralım.
// 5. Sonuçların Les Miserables i içerdiğini assert edelim

public class Question03 {
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
        driver.get("https://www.amazon.com");
        WebElement dropdown= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdown);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        List<WebElement> list=select.getOptions();
        for (WebElement w:list) {
            System.out.println(w.getText());
        }

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Les Miserables"+ Keys.ENTER);

        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());
        Assert.assertTrue(sonuc.getText().contains("Les Miserables"));

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
