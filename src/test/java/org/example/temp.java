package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class temp {

    public static WebDriver driver=null;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testSuggestionDropDown() throws InterruptedException {
        WebElement autoSuggestiveDropdown = driver.findElement(By.id("autocomplete"));
        autoSuggestiveDropdown.click();
        autoSuggestiveDropdown.sendKeys("Uni");
        String countryToSelect = "USA";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("ul[id='ui-id-1']"))));
        List<WebElement> countries = driver.findElements(By.cssSelector("#ui-id-1 li"));




        for (WebElement country : countries){
            if(country.getText().contains(countryToSelect)){
                Actions actions = new Actions(driver);
                actions.moveToElement(country).build().perform();
                System.out.println(country.getText());
                break;
            }
        }

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000L);
        driver.quit();
    }

}
