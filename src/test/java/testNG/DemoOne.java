package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DemoOne {

    @AfterTest
    public void lastExecution(){
        System.out.println("I will execute last");
    }

    @Test
    public void Demo(){
        System.out.println("hello");
    }

    @Test
    public void secondTest(){
        System.out.println("Hi");
    }

    @AfterSuite
    public void adSuite(){
        System.out.println("I am th no 1 from last");
    }
}
