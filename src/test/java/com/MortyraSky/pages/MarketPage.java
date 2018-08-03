package com.MortyraSky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketPage {
    // 1)поиск по тегу "айфоне Х" и проверка корректности вывода отображаемых результатов

    public MarketPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = "input[id='header-search']")
    private WebElement inputField;

    @FindBy(css = "button[role='button']")
    private WebElement findBtn;

    @FindBy(css = ".n-snippet-cell2__title")
    private List<WebElement> titleItems;

    public void findIphone(String searchText){
        inputField.clear();
        inputField.sendKeys(searchText);
        findBtn.click();
    }

    public boolean compareResultItems(String searchText){
        boolean res = false;
        for(int i =0; i < titleItems.size(); i++)
            if(titleItems.get(i).getText().contains(searchText))
                res=true;
        return res;
    }

    public void navigate(String URL){
        driver.get(URL);
    }


}
