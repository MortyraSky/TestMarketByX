package com.MortyraSky.pages;

import com.MortyraSky.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketMagazinePage {
    public MarketMagazinePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    final int COUNTCLICKS = 2;
    String namePhonesOfMaxPrice;
    int maxPricePhone;
    String hrefOfMaxPricesPhone;

    @FindBy(xpath = "//*[@class='n-filter-panel-dropdown__main']/descendant::div[5]/a")
    private WebElement sortByPriceLink;

    @FindBy(css = ".snippet-card__price > .price")
    private List<WebElement> allPricesPhones;

    @FindBy(css = ".snippet-card__action > a")
    private List<WebElement> toStoreBtns;

    @FindBy(css = "h1")
    private WebElement namePhonesInMagazine;

    @FindBy(xpath = "//li[@class='product-price']")
    private WebElement priceInMagazine;

    public void getAttributeHrefPhoneMagazine(){
        hrefOfMaxPricesPhone = toStoreBtns.get(0).getAttribute("href");
    }
    public void goToMagazine(){
        int time = 1;
        getAttributeHrefPhoneMagazine();
        driver.get(hrefOfMaxPricesPhone);
        BaseTest.waitForElements(time);

    }

    public void getPhoneWithMaxPrice(){
        doubleClickBy(sortByPriceLink);

        String strThousand = allPricesPhones.get(0).getText().substring(0,3) + allPricesPhones.get(0).getText().substring(4,7);
        maxPricePhone = Integer.parseInt(strThousand);
    }


    public void doubleClickBy(WebElement element){
        int time = 1;
        for (int i = 0; i < COUNTCLICKS; i++){
            element.click();
            BaseTest.waitForElements(time);
        }

    }

    public boolean comparePhoneInMagazine(){
        boolean resCompare = false;
        String tmp = priceInMagazine.getText().substring(0,6);
        int price = Integer.parseInt(tmp);

        if (price == maxPricePhone)
            resCompare=true;

        return resCompare;

    }

}
