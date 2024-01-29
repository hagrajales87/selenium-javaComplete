package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrames {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void NavigateToHomePage(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void testNestedFrames(){
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("Nested Frames")).click();


        //WebElement firstFrameSet = driver.findElement(By.cssSelector("frameset[rows]"));
        //driver.switchTo().frame(driver.findElement(By.cssSelector("frameset[rows]")));

        WebElement secondFrameSet = driver.findElement(By.cssSelector("frame[name*='top']"));
        driver.switchTo().frame(secondFrameSet);

        WebElement middleFrame = driver.findElement(By.cssSelector("frame[name*='middle']"));
        driver.switchTo().frame(middleFrame);

        System.out.println(driver.findElement(By.id("content")).getText());







    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
