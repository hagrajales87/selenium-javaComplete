package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Calendar {

    public static  WebDriver driver= null;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://www.path2usa.com/travel-companion/");
    }

    @Test
    public void testCalendar() throws InterruptedException {
        String requiredData = "24";
        WebElement dateCalendar = driver.findElement(By.id("form-field-travel_comp_date"));
        scrollTo(dateCalendar);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.elementToBeClickable(dateCalendar));
        //wait.until(ExpectedConditions.visibilityOf(dateCalendar));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(2000L);
        dateCalendar.click();
        String setMonth = "March";
        while (!driver.findElement(By.cssSelector("div[class*='current-month']>span"))
                .getText().equalsIgnoreCase(setMonth)){
            driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
        }
        List<WebElement> calendarDays = driver.findElements(By.xpath("//div[@class='dayContainer']//span[@class='flatpickr-day ']"));

        for(int i=0 ; i < calendarDays.size() ; i++){
            String day = calendarDays.get(i).getText();

            if(calendarDays.get(i).getText().equalsIgnoreCase(requiredData)){
                calendarDays.get(i).click();
                break;
            }
        }
    }

    public static void scrollTo(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",element);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
