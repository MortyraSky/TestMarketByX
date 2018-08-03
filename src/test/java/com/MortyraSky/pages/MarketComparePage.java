package com.MortyraSky.pages;

import com.MortyraSky.tests.BaseTest;
import com.sun.org.apache.xerces.internal.impl.dtd.XMLContentSpec;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
2)сравнение найденных утсройств: смартфон 64гб и 256Гб по всем различающимся характеристикам

 */
//
// //*[@class='n-snippet-cell2__toolbar']/descendant::div/i[1] add to compare
public class MarketComparePage {

    public MarketComparePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@class='n-snippet-cell2__toolbar']/descendant::div/i[1]")
    private List<WebElement> addToCompare;

    @FindBy(xpath = "//*[@class='popup-informer__content']/descendant::div/a")
    private WebElement compareBtn;


    @FindBy(xpath = "//*[@class='n-compare-row']/div/div[2]")
    private WebElement memoryProperties256;

    @FindBy(xpath = "//*[@class='n-compare-row']/div/div[3]")
    private WebElement memoryProperties64;


    public void addToCompareItems(){
        Actions actions = new Actions(driver);
        for (int i=0;i < addToCompare.size(); i++){
            actions.moveToElement(addToCompare.get(i));
            BaseTest.waitForElements(2);
            addToCompare.get(i).click();
        }
    }
    public boolean compareItems(){
        int time = 1;
        boolean res = true;
        compareBtn.click();
        BaseTest.waitForElements(time);
        //allProrerties.click();
        //BaseTest.waitForElements(time);
        res = memoryProperties256.getText().equals(memoryProperties64.getText());
        return res;

    }











}
