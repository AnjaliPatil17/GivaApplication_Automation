package com.giva.testcases;
import com.giva.base.BasePage;
import com.giva.listener.TestListener;
import com.giva.pages.LoginPage;
import com.giva.utils.ExcelFileReading;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;


@Listeners(TestListener.class)
public class LoginTest extends LoginPage {

    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        initialize();
        loginPage=new LoginPage();
    }



//    @Test(priority = 1,dataProvider = "LoginData",dataProviderClass = ExcelFileReading.class)
//    public void loginTest(String emailID,String password){
//       loginPage.loginTest(emailID,password);
//    }

    @Test(priority = 1)
    @Description("User login the application")
    @Epic("EP001")
    @Feature("Feature1 : Login")
    @Story("Story : login the account with emailid and password ")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(){
        loginPage.loginTest();
    }


    @Test
    public void wishListShoppingTest(){
        loginPage.wishListTest();
    }


    @Test(priority = 2,dataProvider = "LoginData",dataProviderClass = ExcelFileReading.class)
    public void LoginWithMultipleUser(String emails,String passs) {
        loginPage.multipleUserLogin(emails,passs);
    }

    @Test(priority = 3)
    public void UserLogin1() {
        loginPage.UserLogin1(properties.getProperty("emailId"), properties.getProperty("pass"));
      //  System.out.println(properties.getProperty("emailId"));
    }


    @Test(priority = 4)
    public void getTitles(){
        String title = loginPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Buy Beautiful Silver, Gold & Lab Grown Diamond Jewellery at Best Price – GIVA Jewellery");
    }


    @AfterMethod
    public void tearDown(){
        closeDriver();
    }






}
