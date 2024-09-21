package com.giva.testcases;

import com.giva.listener.TestListener;
import com.giva.pages.AddToCart;
import com.giva.pages.CheckoutPage;
import com.giva.pages.LoginPage;
import com.giva.pages.SearchPage;
import com.giva.utils.ExcelFileReading;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class CheckoutTest extends CheckoutPage {

    LoginPage loginPage;
    SearchPage searchPage;
    AddToCart addToCart;
    CheckoutPage checkoutPage;


    @BeforeMethod
    public void setup(){
        initialize();
        loginPage=new LoginPage();
        searchPage=new SearchPage();
        addToCart=new AddToCart();
        checkoutPage=new CheckoutPage();

    }


    @Test(priority = 1,dataProvider = "CheckoutGuestData",dataProviderClass = ExcelFileReading.class)
    public void CheckoutForGuestTest(String emailId,String firstName,String lastName,String apartment,String city,String pincode ,String phone) throws InterruptedException {
        searchPage.searchByGuestTests();
        checkoutPage.checkoutForGuestTests( emailId, firstName, lastName, apartment, city,pincode, phone);
    }

    @Test(priority = 2,dataProvider = "CheckoutUserData",dataProviderClass = ExcelFileReading.class)
    public void CheckoutForUserTest(String apartment,String city,String pincode ,String phone) throws InterruptedException {
        loginPage.loginTest();
        searchPage.searchByUserTests();
        addToCart.AddToCartTest();
        checkoutPage.checkoutForUserTests(apartment, city,pincode, phone);
    }




    @AfterMethod
    public void tearDown(){
        closeDriver();
    }


}
