package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingAssignment {

    public static void main(String[] args){
        System.setProperty("webdriver,chrome,driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.cssSelector("#content a")).click();
        switchToWindow("New Window", driver);
        System.out.println(driver.findElement(By.cssSelector("h3")).getText());
        switchToWindow("The Internet", driver);
        System.out.println(driver.findElement(By.cssSelector("div h3")).getText());





    }

    public static void switchToWindow(String pageTitle, WebDriver driver){
        var windows = driver.getWindowHandles();

        for(String window : windows){
            driver.switchTo().window(window);
            System.out.println("Page title: " + driver.getTitle());
            if(driver.getTitle().contains(pageTitle)){
                break;
            }
        }
    }
}
