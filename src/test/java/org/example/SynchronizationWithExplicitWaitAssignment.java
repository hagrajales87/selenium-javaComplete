package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SynchronizationWithExplicitWaitAssignment {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));


        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        Select select = new Select(driver.findElement(By.cssSelector("select.form-control")));
        driver.findElement(By.cssSelector("select.form-control")).click();
        select.selectByVisibleText("Consultant");

        driver.findElement(By.cssSelector("input[name='terms']")).click();
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[class*='shopping-cart']")));
        List<WebElement> productsAvailable = driver.findElements(By.cssSelector("i[class*='shopping-cart']"));
        for(WebElement product : productsAvailable){
            product.click();
        }

        driver.findElement(By.cssSelector("#navbarResponsive a.nav-link")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-success")));
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.quit();

    }
}
