package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.beans.Visibility;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class temporal {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] elementsToAdd = {"Brocolli", "Cucumber", "Carrot", "Banana"};

        addItems(driver, elementsToAdd);

        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.cssSelector(".cart-preview button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");


        WebElement applyButton = driver.findElement(By.cssSelector(".promoBtn"));
        applyButton.click();
        WebElement applyingButtonLoading = driver.findElement(By.cssSelector(".promoBtn .promo-btn-loader"));
        wait.until(ExpectedConditions.visibilityOf(applyingButtonLoading));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
        WebElement message = driver.findElement(By.cssSelector("span[class='promoInfo']"));

        Assert.assertEquals(message.getText(),"Code applied ..!","Invalid Message");






            driver.quit();
    }

    public static void addItems(WebDriver driver, String[] elementsToAdd){

        List elementsNeeded = Arrays.asList(elementsToAdd);

        List<WebElement> elementsAvailable = driver.findElements(By.cssSelector("h4[class='product-name']"));
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".product-action button[type='button']"));

        int numberOfProductsToAdd = elementsToAdd.length;
        for (int i = 0 ; i < elementsAvailable.size() ; i++){
            String element = elementsAvailable.get(i).getText();
            //We are separating the name and the weight
            String[] productDetails = element.split("-");
            String nameElement= productDetails[0].trim();

            if(elementsNeeded.contains(nameElement)){
                addToCartButtons.get(i).click();
                Assert.assertEquals(addToCartButtons.get(i).getText(),"✔ ADDED", "Invalid button name");
                numberOfProductsToAdd--;
            }
            if(numberOfProductsToAdd==0){
                break;
            }

        }
    }
}
