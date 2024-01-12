package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class locatorsDemoTwo {

    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        String name = "Hector";
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.tagName("p")).getText());

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();





    }



    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Hector");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Test");
        driver.findElement(By.cssSelector("form input:nth-child(4)")).sendKeys("876546789");
        driver.findElement(By.xpath("//button[contains(.,'Reset')]")).click();

        String message = driver.findElement(By.className("infoMsg")).getText();
        String[] splitMessage = message.split("'");
        for(String word : splitMessage){
            System.out.println(word);
        }


        return splitMessage[1];
    }
}
