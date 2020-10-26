package com.snapdeal.core.pages;

import com.snapdeal.core.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Iterator;
import java.util.List;

public class SearchResultPage extends BaseClass {

    public List<WebElement> findAllElements(){
        List<WebElement> elements;
                elements= driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));
        return elements;
    }

    public void clickOnHighestPricedPhone(int price) {
        driver.findElement(By.xpath("//span[contains(@display-price,"+price+")]")).click();
    }
}
