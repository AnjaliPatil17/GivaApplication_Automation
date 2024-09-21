package com.giva.pages;

import com.giva.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.giva.base.BasePage.driver;

public class SearchPage extends BasePage {


    public SearchPage(){
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Search-In-Modal")
    WebElement searchBox;

    @FindBy(className = "search__button")
    WebElement searchIcon;

    @FindBy(xpath = "(//a[@id='CardLink--7590923108514'])[1]")
    WebElement productItem;

    @FindBy(id = "ProductBuyButton-template--16317651517602__main")
    WebElement buyButton;

    @FindBy(id = "ProductSubmitButton-template--16317651517602__main")
    WebElement addToCartBtn;



    public void inputSearchBox(){
        searchBox.sendKeys("Rings");
    }

    public void clickSearchIcon(){
        searchIcon.sendKeys(Keys.ENTER);
    }

    public void scrollDown(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("window.scrollBy(0,200)");
        }
    }

    public void clickProductItem(){
        productItem.sendKeys(Keys.ENTER);
    }

    public void clickbuyButton(){
        buyButton.click();
    }

    public void clickAddToCart(){
        addToCartBtn.click();
    }





    public void searchByGuestTests() throws InterruptedException {
        logger.info("Guest searching the product in application");
        inputSearchBox();
        clickSearchIcon();
        scrollDown();
        Thread.sleep(4000);
        clickProductItem();
        logger.info("Guest buy the product item");
        clickbuyButton();
    }

    public void searchByUserTests() throws InterruptedException {
        logger.info("User searching the product in application");
        inputSearchBox();
        clickSearchIcon();
        scrollDown();
        Thread.sleep(4000);
        clickProductItem();
        clickAddToCart();
    }





}
