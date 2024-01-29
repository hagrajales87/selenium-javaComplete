package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options =getChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        return options;
    }

    @BeforeMethod
    public void loadUrl(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testBrokenLinks() throws IOException {
        //Broken URL
        //Step 1 - is to get all urls tied up to the links using Selenium
        //if status code > 400 them that url is not working -> link which tied to url is broken
        //String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode < 400, "The link with Text " + link.getText() + url +" is broken with code " + respCode);
        }
        a.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
