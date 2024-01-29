package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AngularPractice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("div.form-group input[name='name']")).sendKeys("Hector");
        driver.findElement(By.cssSelector("div.form-group input[name='email']")).sendKeys("hagrajales87@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("passwordTest");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();

        Thread.sleep(2000L);
        Select select = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        select.selectByVisibleText("Female");

        driver.findElement(By.id("inlineRadio1")).click();

        //driver.findElement(By.cssSelector("input[type='date']")).click();
        //driver.findElement(By.cssSelector("input[type='date']")).sendKeys("02/02/1992");

        driver.findElement(By.name("bday")).sendKeys("02/02/1992");



        driver.findElement(By.cssSelector("input[class*='btn-success']")).click();


    }
}
