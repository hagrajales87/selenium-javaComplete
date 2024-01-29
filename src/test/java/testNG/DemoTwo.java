package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTwo {

    @Test(groups={"smoke"})
    public void ploan(){
        System.out.println("Loan");
    }

    @BeforeTest
    public void prerequisite(){
        System.out.println("I will execute first");
    }
}
