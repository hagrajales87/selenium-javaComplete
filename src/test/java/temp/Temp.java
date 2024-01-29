package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Temp {

    public static  WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            ChromeOptions options = getOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

    }

    public static ChromeOptions getOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        return options;
    }

    @BeforeMethod
    public void goHomePage(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void calculateAmount(){
        WebElement tableAmount = driver.findElement(By.cssSelector(".tableFixHead #product"));
        scroll(tableAmount);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        //Get a list with the elements that cantains the Amount
        List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int totalAmount = 0;

        for (WebElement amount : amounts){
            totalAmount += Integer.parseInt(amount.getText());
        }

        System.out.println("The total amount is equals to: " + totalAmount);

        // Compare if totalAmount is equals to the value show in the total amount collected section
        int amountCollected = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(totalAmount, amountCollected, "Wrong value");
    }

    public static void scroll(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()",element);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
