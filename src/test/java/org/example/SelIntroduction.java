package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

    public static void main(String[] args){

        // Chrome
        // SeleniumManager (Beta phase)

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
