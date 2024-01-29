package testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class DemoThree {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before executing any methods in the class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println(" I will execute after every test method in DemoThree class");
    }

    @Parameters({"URL", "APIKey/username"})
    @Test//(timeOut = 4000L)
    public void webLoginCarLoan(String urlname, String key){
        //selenium
        System.out.println("WebLoginCar");
        System.out.println(urlname);
        System.out.println(key);
    }

    @Test(enabled = true)
    public void MobileLoginLoan(){
        //Appium
        System.out.println("mobilLoginCar");
        Assert.assertTrue(false);
    }

    @BeforeSuite
    public void Bsuite(){
        System.out.println("I am number One");
    }

    @Test(groups={"smoke"})
    public void MobileLogoutLoan(){
        //Appium
        System.out.println("mobilLogoutCar");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I will execute before every test method in class Demo 3");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I will execute after every test method in class Demo 3");
    }

    @Test(dependsOnMethods = {"webLoginCarLoan"})
    public void LoginAPICarLoan(){
        //Rest API automation
        System.out.println("LoginAPICarLoan");
    }

    @DataProvider
    public Object[][] getData(){
        //1st combination - username password
        //2nd - username password - no credit history
        //3rd - fraudulent credit history

        Object[][] data = new Object[3][2];
        data[0][0] = "firstsetusername";
        data[0][1] = "password";

        //2nd set
        data[1][0] = "secondSetUsername";
        data[1][1] = "secondPassword";

        //3rd set
        data[2][0] = "thirdSetUserName";
        data[2][1] = "thirdPassword";

        return data;

    }

    @Test(dataProvider = "getData")
    public void testDataProvider(String username, String password){
        System.out.println("testDataProvider");
        System.out.println(username);
        System.out.println(password );
    }
}
