package com.giva.pages;

import com.giva.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage extends BasePage {


    public StorePage(){
        super();
        PageFactory.initElements(driver,this);
    }

  //(//span[@class="small-hide"])[1]
    @FindBy(xpath = "//a[@href=\"/pages/store-locator\"][1]")
    WebElement storeLogo;

    @FindBy(xpath = "(//input[@class=\"inputArea\"])")
    WebElement inputCode;

    @FindBy(xpath = "(//div[@class=\"check-btn\"])")
    WebElement checkBtn;

    @FindBy(xpath = "//button[@onclick=\"location.href='https://www.giva.co/pages/view-designs?store-id=68026794146'\"]")
    WebElement seeDesignBtn;

    @FindBy(id = "Details-HeaderMenu-4")
    WebElement GiftStore;

    @FindBy(xpath = "//a[@id=\"HeaderMenu-gift-store-giva-gift-store\"]")
    WebElement givaGiftStore;

    public void clickStoreLogo(){
        storeLogo.click();
    }

    public void EnterinputCode(){
        inputCode.sendKeys("Mumbai");
    }


    public void clickCheckBtn(){
        checkBtn.click();
    }

    public void clickSeeDesignBtn(){
        seeDesignBtn.click();
    }

    public void clickGiftStore(){
        Actions act=new Actions(driver);
        act.moveToElement(GiftStore).perform();
    }

    public void clickGivaGiftStore(){
        givaGiftStore.click();
    }





    public void scrollDown(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("window.scrollBy(0,700)");
            js1.executeScript("window.scrollBy(0,-700)");
        }
    }




    public void findStoreTest() throws InterruptedException {
        logger.info("select the Store using city");
        clickStoreLogo();
        EnterinputCode();
        clickCheckBtn();
        Thread.sleep(50000);
        clickSeeDesignBtn();
    }


    public void GivaGiftStore(){
        logger.info("Store page");
        clickStoreLogo();
        clickGiftStore();
        clickGivaGiftStore();
        scrollDown();

    }

















}
