package javaSteams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LiveDemo {

    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void navigateHomepage(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
    }

    @Test
    public void testTopDetails(){
        /*
        driver.findElement(By.xpath("//a[.='Top Deals']")); //Xpath locator
         */

        driver.findElement(By.cssSelector("div[class='cart'] a:nth-child(2)")).click(); //Css Selector
        navigateTopDealsPage();

        //List<WebElement> vegetableList = driver.findElements(By.cssSelector("table[class*=table] tr"));
        driver.findElement(By.xpath("//tr//th[1]")).click();
        List<WebElement> vegetableList = driver.findElements(By.xpath("//div[contains(@class,'table')]//tr//td[1]"));

       //Option 1
        /*
        List<String> vegetableName = new ArrayList<String>();

        for(WebElement vegetable : vegetableList){
            vegetableName.add(vegetable.getText());
        }
         */

        //Option 2 Using stream
        List<String> vegetableName = vegetableList.stream().map(WebElement::getText).collect(Collectors.toList());

        vegetableName.forEach(System.out::println);

        List<String> sortedList = vegetableName.stream().sorted().toList();
        Assert.assertTrue(vegetableName.equals(sortedList));

        /*
        // scan the element column with getText - > Beans -> print the price of the Beans
        List<String> priceValue = vegetableList.stream().filter(s -> s.getText().contains("Beans")).
                map(this::getPriceVeggie).toList();

        priceValue.forEach(System.out::println);
         */

        // scan the element column with getText - > Rice -> print the price of the Rice
        List<String> priceValue;
        do{
            vegetableList = driver.findElements(By.xpath("//div[contains(@class,'table')]//tr//td[1]"));
            priceValue = vegetableList.stream().filter(s -> s.getText().contains("Rice")).
                    map(this::getPriceVeggie).toList();

            if(priceValue.size() < 1){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while(priceValue.size() < 1);
        priceValue.forEach(System.out::println);

    }

    private String getPriceVeggie(WebElement s) {
        return s.findElement(By.xpath(" following-sibling::td[1]")).getText();
    }

    public static void navigateTopDealsPage(){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
