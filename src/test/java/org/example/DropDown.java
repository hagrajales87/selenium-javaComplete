package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DropDown {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("li a[text*=MAA]")).click();
        Thread.sleep(2000L);
        //driver.findElement(By.xpath("(//a[@value='IXG'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='IXG']")).click();
        driver.quit();

    }
}
