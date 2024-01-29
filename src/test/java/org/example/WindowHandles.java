package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector("body .blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        System.out.println("Parent id: " + parentId);
        String childId = it.next();
        System.out.println("child id: " + childId);
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector("body p.im-para.red")).getText());

        String email = driver.findElement(By.cssSelector("body p.im-para.red")).getText().split("at ")[1].split(" ")[0];
        System.out.println("The Email is " + email);

        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(email);

    }
}
