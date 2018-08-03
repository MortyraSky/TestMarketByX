package com.MortyraSky.pages;

import com.MortyraSky.tests.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketFavoritePage {
    public MarketFavoritePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebDriver driver;


    /*
    3)добавление понравившегося устройства из списка сравнения в отложенные
    -) Запомнить имя понравившегося устройства, нажать добавить в избранное
    -) перейти в избранное, проверить, что имена совпадают
     */

    @FindBy(css = ".n-compare-head__name")
    private List<WebElement> nameLikedPhone;

    @FindBy(xpath = "//*[@class='n-compare-head__toolbar']/descendant::i[1]")
    private List<WebElement> addToFavorite; // first moveTo, second click

    @FindBy(css = ".popup-informer__controls > a")
    private WebElement goToFavoriteBtn;

    @FindBy(xpath = "//*[@class='snippet-card__content']/descendant::h3/a")
    private WebElement nameFavoritePhone;


    @FindBy(xpath = "//*[@class='header2__right']/div/span/span[2]")
    private WebElement location;

    @FindBy(xpath = "//*[@class='header2-region-popup']/descendant::input[@class='input__control']")
    private WebElement inputLocationField;

    @FindBy(xpath = "//*[@class='region-suggest__list suggest2__content suggest2__content_theme_normal']/div[1]")
    private WebElement firstValueOfList;

    @FindBy(xpath = "//*[@class='header2-region-popup']/button[@type='submit']")
    private WebElement changeLocationBtn;

    String namePhoneBeforeAddToFavorite;
    String namePhoneAfterAddToFavorite;

    public String getPhoneName(WebElement element){
        return element.getText();

    }

    public boolean addToFavoriteIphone(int numberLikedIPhone){
        //int size = addToFavorite.size();
        //int size2 = nameLikedPhone.size();
        int time = 1;
        //BaseTest.waitForElements(time);

        namePhoneBeforeAddToFavorite = getPhoneName(nameLikedPhone.get(numberLikedIPhone));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToFavorite.get(numberLikedIPhone));
        actions.click(addToFavorite.get(numberLikedIPhone));
        actions.perform();
        BaseTest.waitForElements(time);
        goToFavoriteBtn.click();
        BaseTest.waitForElements(time);
        namePhoneAfterAddToFavorite = getPhoneName(nameFavoritePhone);

        return compareNamePhones(namePhoneBeforeAddToFavorite, namePhoneAfterAddToFavorite);

    }

    public boolean compareNamePhones(String nameBeforeAdd, String nameAfterAdd){
        if (nameBeforeAdd.equals(nameAfterAdd))
            return true;
        else return false;
    }


    public void workWithModeWindow(){
        location.click();

        inputLocationField.clear();
        inputLocationField.sendKeys("Москва");
        BaseTest.waitForElements(1);
        firstValueOfList.click();
        //WebElement element = driver.findElement("//*[@class='header2-region-popup']/button[@type='submit']");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", element);
        changeLocationBtn.click();
        BaseTest.waitForElements(5);

        //alert.accept();

    }
}
