package testNG;

import org.testng.annotations.Test;

public class DemoFour {
    @Test(groups={"smoke"})
    public void webLogin(){
        //selenium
        System.out.println("WebLoginHome");
    }

    @Test
    public void MobileLoginLoan(){
        //Appium
        System.out.println("mobilLoginHome");
    }

    @Test
    public void LoginAPIcarLoan(){
        //Rest API automation
        System.out.println("APILoginHome");
    }
}
