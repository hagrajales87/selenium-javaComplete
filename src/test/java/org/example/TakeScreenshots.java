package org.example;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.io.File;

public class TakeScreenshots {

    public static WebDriver driver;

    @BeforeClass
   public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void takeScreenShoot(){
        driver.get("http://google.com");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Assert.assertEquals(driver.getTitle(),"Yahoo","Invalid page");



    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(src,new File("src/main/resources/screenshots/" +result.getName()+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
