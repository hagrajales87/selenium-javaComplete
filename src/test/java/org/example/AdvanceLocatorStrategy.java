package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvanceLocatorStrategy {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Option 1
        /*
        WebElement cucumber = driver.findElement(By.xpath("//div[@class='product'] //img[contains(@alt,'Cucumber')]/parent::div/parent::div//button"));
        cucumber.click();

        Assert.assertEquals(cucumber.getText(),"✔ ADDED","Invalid button message");
         */

        /*
        //Option 2

        String name = "cucumber";
        List<WebElement> nameProducts = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addToCardButtons = driver.findElements(By.cssSelector("div[class='product'] button"));
        for(int i = 0 ; i < nameProducts.size() ; i++){

            if(nameProducts.get(i).getText().contains(name)){
                addToCardButtons.get(i).click();
                Assert.assertEquals(addToCardButtons.get(i).getText(),"✔ ADDED","Invalid button message");
                break;
            }

        }
         */

        /*
        //Option 3 - Suppose we need to select several products


        String name = "cucumber";
        List<WebElement> nameProducts = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addToCardButtons = driver.findElements(By.cssSelector("div[class='product'] button"));
        for(int i = 0 ; i < nameProducts.size() ; i++){

            if(nameProducts.get(i).getText().contains(name)){
                addToCardButtons.get(i).click();
                Assert.assertEquals(addToCardButtons.get(i).getText(),"✔ ADDED","Invalid button message");
                break;
            }

        }
         */

        // Option 4 Several products
        String[] itemsToAdd = {"Brocolli","Cucumber","Beans","Banana"};
        List<WebElement> nameProducts = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> addToCardButtons = driver.findElements(By.cssSelector("div[class='product'] button"));

        List items = Arrays.asList(itemsToAdd);

        int j = 0;
        for(int i = 0 ; i < nameProducts.size() ; i++){
            String name = nameProducts.get(i).getText();
            String[] productName = name.split("-");
            String formattedName = productName[0].trim();


            if(items.contains(formattedName)){
                addToCardButtons.get(i).click();
                Assert.assertEquals(addToCardButtons.get(i).getText(),"✔ ADDED","Invalid button message");
                j--;
            }

            if(j== itemsToAdd.length){
                break;
            }

        }

        driver.quit();
    }
}
