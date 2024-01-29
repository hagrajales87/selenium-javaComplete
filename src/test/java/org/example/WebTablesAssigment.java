package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTablesAssigment {

    public static WebDriver driver = null;
    @BeforeClass
    public void setUp(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            ChromeOptions options = getChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }

    }


    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        return options;
    }

    @BeforeMethod
    public void navigateToHomePage(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @Test
    public void test() throws InterruptedException {
        WebElement table = driver.findElement(By.cssSelector(".left-align #product"));
        scrollToWebElement(table);
        Thread.sleep(3000L);

        List<WebElement> tableRows = driver.findElements(By.cssSelector("div[class*='left'] table tr"));
        System.out.println("Number of rows equals to: " + tableRows.size());

        WebElement secondInstructor = tableRows.get(2);

        // Number of Columns
        System.out.println("Number of columns equals to:" + secondInstructor.findElements(By.tagName("td")).size());

        for(WebElement instructorInformation : secondInstructor.findElements(By.tagName("td"))){
            System.out.println(instructorInformation.getText());
        }


    }

    public static void scrollToWebElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",element);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
