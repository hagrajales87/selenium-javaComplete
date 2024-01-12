package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Checkboxes {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

        System.out.println("Number of checkboxes present in the page: " +
                driver.findElements(By.cssSelector("input[type='Checkbox']")).size());

        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='Checkbox']")).size(),3,
                "Invalid number of checkboxes");

        Thread.sleep(3000L);

        driver.quit();
    }
}
