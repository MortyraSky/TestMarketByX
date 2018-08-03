package com.MortyraSky.tests;

import com.MortyraSky.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
//*[@class='n-compare-head__toolbar']/descendant::i[1]

1)поиск по тегу "айфоне Х" и проверка корректности вывода отображаемых результатов

2)сравнение найденных утсройств: смартфон 64гб и 256Гб по всем различающимся характеристикам

3)добавление понравившегося устройства из списка сравнения в отложенные

4)изменение региона в списке на Москва и проверка изменения данных по отложенным устройствам.

5)сравнение цен на отложенное устройство с сортировкой по рейтингу и цене

6)выбор устройства с максимальной ценой и редирект "В магазин" для покупки.

 */



public class MainTetst extends BaseTest{

    final String SEARCHTEXT = "iPhone X";
    final String URL = "https://market.yandex.ru";
    final String CITY = "Москва";
    final int NUMBERLIKEDIPHONES = 0;


    MarketPage marketPage;
    MarketComparePage marketComparePage;
    MarketFavoritePage marketFavoritePage;
    MarketDefferedPage marketDefferedPage;
    MarketSortPage marketSortPage;
    MarketMagazinePage marketMagazinePage;

    @Test
    public void MarketTest1(){
        marketPage = new MarketPage(driver);
        boolean resSearch;

        marketPage.navigate(URL);
        marketPage.findIphone(SEARCHTEXT);
        resSearch = marketPage.compareResultItems(SEARCHTEXT);
        Assert.assertTrue(resSearch);
    }

    @Test
    public void MarketTest2(){
        marketComparePage = new MarketComparePage(driver);
        boolean resCompare;

        marketComparePage.addToCompareItems();
        resCompare = marketComparePage.compareItems();
        Assert.assertFalse(resCompare);

    }

    @Test
    public void MarketTest3(){
        marketFavoritePage = new MarketFavoritePage(driver);
        boolean resAddToFavorite;

        resAddToFavorite = marketFavoritePage.addToFavoriteIphone(NUMBERLIKEDIPHONES);
        Assert.assertTrue(resAddToFavorite);


    }

    @Test
    public void MarketTest4(){
        marketDefferedPage = new MarketDefferedPage(driver);
        boolean res;

        res = marketDefferedPage.changeLocationAndCompareResult(CITY);
        Assert.assertFalse(res);
    }

    @Test
    public void MarketTest5(){
        marketSortPage = new MarketSortPage(driver);
        boolean res;

        marketSortPage.sortOffers();
        res = marketSortPage.isSorted();
        Assert.assertTrue(res);
    }

    @Test
    public void MarketTest6(){
        marketMagazinePage = new MarketMagazinePage(driver);
        boolean res;

        marketMagazinePage.getPhoneWithMaxPrice();
        marketMagazinePage.goToMagazine();
        res = marketMagazinePage.comparePhoneInMagazine();
        Assert.assertTrue(res);

    }


}
