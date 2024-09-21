package com.giva.testcases;
import com.giva.base.BasePage;
import com.giva.listener.TestListener;
import com.giva.pages.RegisterPage;
import com.giva.utils.ExcelFileReading;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(TestListener.class)
public class RegisterTest extends RegisterPage {

    RegisterPage registerPage;

    @BeforeMethod
    public void setup(){
        initialize();
        registerPage=new RegisterPage();
    }



    @Test(dataProvider = "RegisterData",dataProviderClass = ExcelFileReading.class)
    public void registerTest(String firstName,String lastName,String emailID,String password){
        registerPage.registerTest(firstName,lastName,emailID,password);

    }



    @AfterMethod
    public void tearDown(){
        closeDriver();
    }






}
