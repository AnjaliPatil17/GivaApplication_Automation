package com.giva.testcases;

import com.giva.listener.TestListener;
import com.giva.pages.AddToCart;
import com.giva.pages.LoginPage;
import com.giva.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AddToCartTest extends AddToCart {
    LoginPage loginPage;
    SearchPage searchPage;
    AddToCart addToCart;

    @BeforeMethod
    public void setup(){
        initialize();
        loginPage=new LoginPage();
        searchPage=new SearchPage();
        addToCart = new AddToCart();
    }


    @Test(priority = 1)
    public void AddToCartTest(){
        addToCart.AddToCartTest();
    }


    @Test(priority = 2)
    public void cartTest() throws InterruptedException {
        loginPage.loginTest();
        searchPage.searchByUserTests();
        addToCart.CartTest();
    }

    @Test(priority = 3)
    public void cartOfferTest(){
        addToCart.CartOfferTest();
    }



    @AfterMethod
    public void tearDown(){
        closeDriver();
    }



}
