package seleniumFour.MultipleWindowsTABS;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {

    public static WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        if(driver ==null){
            System.setProperty("webdriver.Edge.driver", "src/main/resources/msedgedriver");
            FirefoxOptions options = getOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();

        }
    }

    @BeforeMethod
    public void loadHomePage(){
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }

    public static FirefoxOptions getOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headles");
        return options;
    }

    @Test
    public void testNewWindow() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        WebElement coursesSection = driver.findElement(By.cssSelector(".pull-left h2"));
        scroll(coursesSection);
        String javaAutomationCurse = driver.findElements(By.cssSelector("a[href*='core-java']")).get(1).getText();

        driver.switchTo().window(parentWindowId);
        WebElement name = driver.findElement(By.cssSelector(".form-group input[name='name']"));
        name.sendKeys(javaAutomationCurse);
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/resources/screenshots/"+"logo.png"));

        //Get Height & Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
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

