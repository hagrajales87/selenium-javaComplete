package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class locator3 {

    public static void main(String[] args){
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        driver.quit();

    }
}
