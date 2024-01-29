package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandleTwo {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.xpath("//a[contains(.,'Free Access')]")).click();

        switchToWindow("RS Academy", driver);

        String email = driver.findElement(By.cssSelector("p.red")).getText().split("at ")[1].split(" ")[0];

        switchToWindow("LoginPage", driver);
        driver.findElement(By.id("username")).sendKeys(email);



    }

    public static void switchToWindow(String windowTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
            if(driver.getTitle().contains(windowTitle)){
                break;
            }
        }
    }
}
