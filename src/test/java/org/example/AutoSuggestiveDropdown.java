package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AutoSuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//body //div[@id ='select-class-example'] //*[@id='autosuggest']")).sendKeys("ind");
        Thread.sleep(2000L);

        List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item"));

        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
        Thread.sleep(2000L);
        driver.quit();

    }
}
