package com.snapdeal.core.pages;

import com.snapdeal.core.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;

public class SearchResultPage extends BaseClass {

    public void findAllElements(){
        List<WebElement> elements = driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));
        System.out.printf("\nPrice: "+ elements.stream.max((Comparator<? super WebElement>) elements.listIterator()));
    }

    public void openHighestPricediPhone(){

    }

}
