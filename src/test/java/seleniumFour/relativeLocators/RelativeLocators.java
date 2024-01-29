package seleniumFour.relativeLocators;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocators {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        if(driver == null){
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
            FirefoxOptions options = getFirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }

    }

    public static FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        return options;
    }


    @BeforeMethod
    public void loadHomePage(){
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }

    @Test
    public void testRelativeLocators(){
        //driver.findElement(By.xpath("//a[contains(.,'Practise - 3')]")).click();
        //driver.findElement(By.linkText("Automation Practise - 3")).click();
        WebElement nameEditBox = driver.findElement(By.cssSelector(".form-group input[name='name']"));
        String nameTitle = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
        System.out.println(nameTitle);

        WebElement dateOfBirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        scroll(dateOfBirth);
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement loveIceCream = driver.findElement(By.xpath("//label[contains(.,'IceCreams')]"));
        driver.findElement(with(By.tagName("input")).toLeftOf(loveIceCream)).click();

        WebElement firstCheckBox = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(firstCheckBox)).getText());

    }

    public static void scroll(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()",element);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(src, new File("src/main/resources/screenshots" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
