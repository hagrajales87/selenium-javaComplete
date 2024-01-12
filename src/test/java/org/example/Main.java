package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        //WebDriver driver = new ChromeDriver();

        //Firefox Launch
        //geckodriver
        //System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        //WebDriver driver = new FirefoxDriver();

        //Edge Launch
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver");
        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        //driver.close();
        driver.quit();

    }
}