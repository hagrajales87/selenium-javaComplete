package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsDemo2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("wedriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();

        String name = "Hector";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button[class*='submit']")).click();

        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " + name + ",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.quit();
    }
}
