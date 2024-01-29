package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest {

    public static WebDriver driver= null;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }


    @Test
    public void ValidateDragAndDrop(){

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.cssSelector("body #draggable"));
        WebElement target = driver.findElement(By.cssSelector("body #droppable"));

        actions.dragAndDrop(source,target).build().perform();

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[.='Accept']")).click();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        driver=null;
    }
}
