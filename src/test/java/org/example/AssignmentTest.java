package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentTest {

    public static WebDriver driver=null;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void getUrl(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testPage(){
        WebElement checkbox = driver.findElement(By.cssSelector("label[for='benz']"));
        checkbox.findElement(By.id("checkBoxOption2")).click();


        String optionText = checkbox.getText().trim();

        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByVisibleText(optionText);

        driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(optionText);
        driver.findElement(By.id("alertbtn")).click();
        String alertText= driver.switchTo().alert().getText();

        Assert.assertTrue(alertText.contains(optionText),"Invalid text");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
