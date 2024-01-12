package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowActivities {

    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.navigate().to("https://rahulshettyacademy.com/");
        driver.navigate().back();
        driver.navigate().forward();
    }

}
