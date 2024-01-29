package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class e2e {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[id*='originStation1_CTXT']")).click();
        driver.findElement(By.cssSelector("a[value='DEL']")).click();

        Thread.sleep(2000L);

        //driver.findElement(By.cssSelector("input[id*='destinationStation1']")).click();
        driver.findElement(By.cssSelector(".right1 a[value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-highlight")).click();

        Thread.sleep(2000L);
        driver.findElement(By.id("divpaxinfo")).click();
        while(!driver.findElement(By.id("spanAudlt")).getText().equalsIgnoreCase("5")){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.cssSelector("#btnclosepaxoption")).click();

        driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();

        driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();

        List<WebElement> currencies = driver.findElements(By.cssSelector("#ctl00_mainContent_DropDownListCurrency option"));

        for (WebElement currency: currencies){
            if(currency.getAttribute("value").equalsIgnoreCase("USD")){
                currency.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[id*='FindFlights']")).click();
    }
}
