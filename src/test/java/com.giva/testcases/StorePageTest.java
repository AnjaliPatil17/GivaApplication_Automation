package com.giva.testcases;

import com.giva.listener.TestListener;
//import com.giva.pages.AddToCart;
import com.giva.pages.StorePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class StorePageTest extends StorePage {
    StorePage storePage;

    @BeforeMethod
    public void setup(){
        initialize();
        storePage = new StorePage();
    }


    @Test(priority = 1)
    public void FindStoreTest() throws InterruptedException {
        storePage.findStoreTest();
    }

    @Test(priority = 2)
    public void givaGiftStore() {
        storePage.GivaGiftStore();
    }




    @AfterMethod
    public void tearDown(){
        closeDriver();
    }



}
