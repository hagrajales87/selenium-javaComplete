package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

    public static void main(String[] args){
        System.setProperty("wedriver.edge.driver", "src/main/resources/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement dropDownElement = driver.findElement(By.cssSelector("select[name*='ListCurrency']"));

        Select dropDown = new Select(dropDownElement);
        dropDown.selectByIndex(3);

        System.out.println(dropDown.getFirstSelectedOption().getText());

        dropDown.selectByVisibleText("AED");
        System.out.println(dropDown.getFirstSelectedOption().getText());

        dropDown.selectByValue("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());



    }
}
