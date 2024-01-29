package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ScrollJavascriptExecutor {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testScroll(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",
                driver.findElement(By.cssSelector(".tableFixHead")));

        jse.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
        List<WebElement> total = driver.findElements(By.cssSelector("#product td:nth-child(4)"));

        int totalAmount = 0;
        for(var amount : total){

                totalAmount+=Integer.parseInt(amount.getText());
        }

        System.out.println("Total amount equals to: " +  totalAmount);

        Assert.assertEquals(Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()),totalAmount,"Total amount is incorrect");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
