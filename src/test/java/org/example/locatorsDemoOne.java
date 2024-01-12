package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class locatorsDemoOne {

    //implicit wait

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("UsernameField");
        driver.findElement(By.name("inputPassword")).sendKeys("passwordField");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Hector");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Hector@test.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("hector.grajales@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876453467");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.cssSelector("button[class*=login]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Hector");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        /*
        locatorsDemoOne locators = new locatorsDemoOne();
        String newPassword = locators.getPassword(driver);
        System.out.println("The new password is: " + newPassword);
         */

        driver.quit();
    }

    public String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Hector");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Test");
        driver.findElement(By.cssSelector("form input:nth-child(4)")).sendKeys("876546789");
        driver.findElement(By.xpath("//button[contains(.,'Reset')]")).click();

        String message = driver.findElement(By.className("infoMsg")).getText();
        String[] splitMessage = message.split("'");
        for(String word : splitMessage){
            System.out.println(word);
        }


        return splitMessage[1];
    }
}
