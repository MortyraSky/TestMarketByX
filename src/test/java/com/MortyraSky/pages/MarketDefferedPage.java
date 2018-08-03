package com.MortyraSky.pages;

import com.MortyraSky.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MarketDefferedPage {
/*
4)изменение региона в списке на Москва и проверка изменения данных по отложенным устройствам.

 */

    public MarketDefferedPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@class='snippet-card__content']/descendant::h3/a")
    private WebElement nameFavoritePhone;

    @FindBy(xpath = "//*[@class='n-product-top-offer__content']/div[1]/a")
    private List<WebElement> currentNameStores; // put name stores of Penza, after Moscow

    ArrayList<String> previusNamesStores = new ArrayList<String>(); // remember name stores Penza

    @FindBy(xpath = "//*[@class='header2__right']/descendant::span[2]")
    private WebElement location;

    @FindBy(xpath = "//*[@class='header2-region-popup']/descendant::input[@class='input__control']")
    private WebElement inputLocationField;

    @FindBy(xpath = "//*[@class='region-suggest__list suggest2__content suggest2__content_theme_normal']/div[1]")
    private WebElement firstValueOfList;

    @FindBy(xpath = "//*[@class='header2-region-popup']/button[@type='submit']")
    private WebElement changeLocationBtn;

    @FindBy(css = ".n-product-top-offers-list__title")
    private WebElement allStores;



    public boolean changeLocationAndCompareResult(String city){

        nameFavoritePhone.click();
        getNameStores(currentNameStores);
        location.click();

        inputLocationField.clear();
        inputLocationField.sendKeys(city);
        BaseTest.waitForElements(1);
        firstValueOfList.click();

        changeLocationBtn.click();

        BaseTest.waitForElements(1);
        return compareStoresName(currentNameStores, previusNamesStores);





    }


    public boolean compareStoresName(List<WebElement> currentNameStores, ArrayList<String> previusNameStores){
        boolean res = true;

        for (int i = 0; i < currentNameStores.size(); i++){
            if(!currentNameStores.get(i).getText().equals(previusNameStores.get(i)))
                res = false;
            else {
                res = true;
                break;
            }
        }
        return res;
    }

    public void getNameStores(List<WebElement> nmStrs){
        for (int i=0;i < nmStrs.size(); i++){
            previusNamesStores.add(nmStrs.get(i).getText());
            System.out.println("Название магазинов :" + previusNamesStores.get(i));
        }
    }




}
