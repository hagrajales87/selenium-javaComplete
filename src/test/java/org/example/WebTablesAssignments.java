package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesAssignments {

    public static WebDriver driver=null;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver,chrome,driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tableTest(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement webTableExample = driver.findElement(By.cssSelector(".left-align table#product"));
        scroll(webTableExample);
        List <WebElement> tableByRows = driver.findElements(By.cssSelector("div[class*='left'] tbody tr"));
        System.out.println("The table have " + tableByRows.size() + " rows");
        int instructor = 2;
        List<WebElement> instructorInformation = tableByRows.get(instructor).findElements(By.tagName("td"));

        System.out.println("The table have " + instructorInformation.size() + " columns");

        for(WebElement info : instructorInformation){
            System.out.println(info.getText());
        }
    }

    public static void scroll(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",element);

    }
}
