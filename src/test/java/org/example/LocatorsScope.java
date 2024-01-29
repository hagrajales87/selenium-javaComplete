package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class LocatorsScope {

    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void locatorsScope(){

        //How many links have the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //How many links there are in the footer
        WebElement footer = driver.findElement(By.id("gf-BIG"));

        System.out.println(footer.findElements(By.tagName("a")).size());

        // locate just the elements on the footer that are on the first column

        WebElement firstColumnFooter = footer.findElement(By.xpath("//tr/td[1]/ul"));
        System.out.println(firstColumnFooter.findElements(By.tagName("a")).size());

        //Open each link on a different Tab
        for(int i = 0 ; i < firstColumnFooter.findElements(By.tagName("a")).size(); i++){

            String openLinksOnANewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstColumnFooter.findElements(By.tagName("a")).get(i).sendKeys(openLinksOnANewTab);
        }


        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }




    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
