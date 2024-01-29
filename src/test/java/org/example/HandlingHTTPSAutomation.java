package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HandlingHTTPSAutomation {

    @Test
    public void check() throws InterruptedException {
        /*
        FirefoxOptions optionsF = new FirefoxOptions();
        optionsF.setAcceptInsecureCerts(true);
        WebDriver driverF = new FirefoxDriver(optionsF);
        driverF.get("https://expired.badssl.com/");

        EdgeOptions optionsE = new EdgeOptions();
        optionsE.setAcceptInsecureCerts(true);
        WebDriver driverE = new EdgeDriver(optionsE);
        driverE.get("https://expired.badssl.com/");

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver,driver,chrome","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
         */

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");



        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.hexacta.com/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span[aria-label='close']"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='close']")));
        driver.findElement(By.cssSelector("span[aria-label='close']")).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("span[aria-label='close']"))));

        driver.findElement(By.cssSelector("a[class='searchbox']")).click();
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Outsource");
        driver.findElement(By.cssSelector("input[type='search']")).submit();

        List<WebElement> subTitles = driver.findElements(By.cssSelector("div h3 a"));
        for(var subTitle : subTitles ){
            if(subTitle.getText().trim().equalsIgnoreCase("Hiring a development team: factors that scream outsource now!")){
                System.out.println("Test Pass!");
                break;
            }
        }

        Thread.sleep(5000L);
        driver.quit();


    }
}
