package com.giva.pages;

import com.giva.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends BasePage {

    public AddToCart(){
        super();
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//a[@href=\"/cart\"]")
    WebElement cartLogo;

   // @FindBy(id = "checkout")
    @FindBy(xpath = "//button[@class=\"button button--primary button--full-width checkout-securely\"]")
    WebElement checkoutBtn;

    @FindBy(xpath = "//a[@id=\"HeaderMenu-offers\"]")
    WebElement offerIcon;

   public void clickCartLogo(){
       cartLogo.click();
   }

    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

    public void clickOfferIcon(){
        offerIcon.click();
    }


    public void scrollDown(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("window.scrollBy(0,200)");
        }
    }




   public void AddToCartTest(){
      // clickCartLogo();
       logger.info("Add the product item to cart");
       scrollDown();
       clickCheckoutBtn();
   }


    public void CartTest(){
        clickCartLogo();
        logger.info("Open the cart");
        scrollDown();
        //clickCheckoutBtn();
    }

    public void CartOfferTest(){
        clickCartLogo();
        logger.info("Open the cart");
        clickOfferIcon();
        logger.info("Open the Offer page");
        scrollDown();
    }



}
