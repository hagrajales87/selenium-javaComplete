package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsDemo {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


        WebElement searchButton = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement signInMenu = driver.findElement(By.id("nav-link-accountList"));
        Actions  action = new Actions(driver);

        //Hover on an web element
        action.moveToElement(signInMenu).build().perform();

        //Select a text field and write a message in capital letters
        action.moveToElement(searchButton).click()
                .keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();

        //double-click on a specific element
        action.moveToElement(searchButton).doubleClick().build().perform();

        // Right-click on an specific element
        action.moveToElement(signInMenu).contextClick().build().perform();






    }
}
