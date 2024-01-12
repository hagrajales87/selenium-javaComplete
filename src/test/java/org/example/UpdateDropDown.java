package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UpdateDropDown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected(),
                "Checkbox is selected");
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected(), "Check box was not selected");
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());


        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        while(!driver.findElement(By.id("spanAudlt")).getText().equalsIgnoreCase("5")){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult", "Invalid number of adults");
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());


        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected(),
                "One Way trip radio button is not selected");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[id='Div1']")).getText().contains("1"), "Element is inactive");

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected(),
                "One Way trip radio button was not unselected");

        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected(),
                "Round trip radio button was not selected");


        System.out.println(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));

        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        WebElement firstAvailableDate = driver.findElement(By.cssSelector("a[class*= 'ui-state-highlight']"));
        firstAvailableDate.click();

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        /*
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled(),
                "Return date must be disabled when One Way Bool Flight is selected");
         */

        Thread.sleep(1000L);
        System.out.println(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("0.5"), "Element is not inactive");

        driver.quit();
    }
}
