package com.giva.testcases;

import com.giva.base.BasePage;
import com.giva.listener.TestListener;
import com.giva.pages.*;
import com.giva.utils.ExcelFileReading;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.giva.base.BasePage.logger;


@Listeners(TestListener.class)
public class Tests extends BasePage{

    LoginPage loginPage;
    StorePage storePage;
    SearchPage searchPage;
    AddToCart addToCart;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup(){
        initialize();
        logger.info("Giva Shopping Method Running....");
        loginPage=new LoginPage();
        storePage = new StorePage();
        searchPage=new SearchPage();
        addToCart=new AddToCart();
        checkoutPage=new CheckoutPage();
    }



    @Test(priority = 1,dataProvider = "CheckoutGuestData",dataProviderClass = ExcelFileReading.class)
    @Description("Shopping as a guest was completed.")
    @Epic("EP001")
    @Feature("Feature1 : Order the Product by Guest ID")
    @Story("Story : Order the Product item using cash on delivery")
    @Step("Buy the product item with cash on delivery using guest ID")
    @Severity(SeverityLevel.CRITICAL)

   public void shoppingByGuest(String emailId,String firstName,String lastName,String apartment,String city,String pincode ,String phone) throws InterruptedException {
        searchPage.searchByGuestTests();
        checkoutPage.checkoutForGuestTests( emailId, firstName, lastName, apartment, city,pincode, phone);
    }




    @Test(priority = 2,dataProvider = "CheckoutUserData",dataProviderClass = ExcelFileReading.class)
    @Description("Shopping as a User was completed.")
    @Epic("EP001")
    @Feature("Feature1 : Order the Product using User account")
    @Story("Story : Login the application place an Order for the Product item using cash on delivery ")
    @Step("Buy the product item form cart with cash on delivery using user account")
    @Severity(SeverityLevel.CRITICAL)
    public void shoppingByUser(String apartment,String city,String pincode ,String phone) throws InterruptedException {
        loginPage.loginTest();
        searchPage.searchByUserTests();
        addToCart.AddToCartTest();
        checkoutPage.checkoutForUserTests(apartment, city,pincode, phone);
    }



    @Test(priority = 3,dataProvider = "CheckoutGuestData",dataProviderClass = ExcelFileReading.class)
    @Description("Shopping through store as a guest was completed.")
    @Epic("EP003")
    @Feature("Feature1 : Order the Product from store by Guest ID")
    @Story("Story : Order the Product item from store using cash on delivery")
    @Step("Search and Buy the product item from store with cash on delivery using guest ID")
    @Severity(SeverityLevel.CRITICAL)
    public void guestShopThroughStore(String emailId,String firstName,String lastName,String apartment,String city,String pincode ,String phone) throws InterruptedException {
        storePage.findStoreTest();
        searchPage.searchByGuestTests();
        checkoutPage.checkoutForGuestTests( emailId, firstName, lastName, apartment, city,pincode, phone);
    }




    @Test(priority = 4,dataProvider = "CheckoutUserData",dataProviderClass = ExcelFileReading.class)
    @Description("Shopping through store as a User was completed.")
    @Epic("EP004")
    @Feature("Feature1 : Order the Product from store using User account")
    @Story("Story : Login the application place an Order for the Product item from cart using cash on delivery ")
    @Step("Search Store and add the product item to cart with cash on delivery using user account")
    @Severity(SeverityLevel.CRITICAL)
    public void userShopThroughStore(String apartment,String city,String pincode ,String phone) throws InterruptedException {
        loginPage.loginTest();
        storePage.findStoreTest();
        searchPage.searchByUserTests();
        addToCart.AddToCartTest();
        checkoutPage.checkoutForUserTests(apartment, city,pincode, phone);
    }



    @AfterMethod
    public void tearDown(){
        closeDriver();
    }





}
