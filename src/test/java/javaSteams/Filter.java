package javaSteams;

import org.openqa.selenium.By;
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
import java.util.Set;

public class Filter {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            ChromeOptions options = getOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }


    }

    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise");



    }

    @Test
    public void testFilter(){
        driver.findElement(By.xpath("//a[.='Top Deals']")).click();
        swithToNewTab();
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> vegetables = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> filteredList = vegetables.stream().filter(s -> s.getText().equals("Rice")).toList();

        Assert.assertEquals(vegetables.size(),filteredList.size());
    }

    public static void swithToNewTab(){
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
        }
    }

    public static ChromeOptions getOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        return options;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
