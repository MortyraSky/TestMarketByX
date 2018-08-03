package com.MortyraSky.pages;

import com.MortyraSky.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MarketSortPage {
    public MarketSortPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    /*
    5)сравнение цен на отложенное устройство с сортировкой по рейтингу и цене

     */

    @FindBy(css = ".n-w-product-average-price__offers-link-wrap > a")
    private WebElement allPriceLink;

    @FindBy(css = ".snippet-card__price > .price")
    private List<WebElement> allPricesInStores;

    @FindBy(xpath = "//*[@class='n-filter-panel-dropdown__main']/descendant::div[6]/a")
    private WebElement sotrByPriceAndRatingLink;

    ArrayList<Integer> priceInStores = new ArrayList<Integer>();

    public void sortOffers(){
        int time = 2;
        allPriceLink.click();
        BaseTest.waitForElements(time);
        sotrByPriceAndRatingLink.click();
        BaseTest.waitForElements(time);
        System.out.println("Количество отсортированных элементов по цене : " + allPricesInStores.size());

    }

    public void getSortedPrices(){
        int i = 0;
        if (!priceInStores.isEmpty())
            priceInStores.clear();
        for(WebElement e : allPricesInStores){
            System.out.println(e.getText());
            String strThousand = e.getText().substring(0,2) + e.getText().substring(3,6);
            System.out.println("Перевод : " + strThousand);
            priceInStores.add(Integer.parseInt(strThousand));
            System.out.println("Результат в числовом варианет: " + priceInStores.get(i));
            i++;
        }
    }

    public boolean isSorted(){
        boolean resultSorted = false;
        getSortedPrices();
        for(int i = 0; i < priceInStores.size() - 1; i++){
            if(priceInStores.get(i) <= priceInStores.get(i+1))
                resultSorted = true;
            else{
                resultSorted = false;
                break;
            }
        }
        return resultSorted;

    }
}
