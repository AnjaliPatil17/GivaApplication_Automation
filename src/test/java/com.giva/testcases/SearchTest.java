package com.giva.testcases;

import com.giva.listener.TestListener;
import com.giva.pages.RegisterPage;
import com.giva.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




@Listeners(TestListener.class)
public class SearchTest extends SearchPage{


    SearchPage searchPage;

    @BeforeMethod
    public void setup(){
        initialize();
        searchPage=new SearchPage();
    }

    @Test
    public void searchByGuestTest() throws InterruptedException {
        searchPage.searchByGuestTests();
    }

    @Test
    public void searchByUserTest() throws InterruptedException {
        searchPage.searchByUserTests();
    }



    @AfterMethod
    public void tearDown(){
        closeDriver();
    }



}
