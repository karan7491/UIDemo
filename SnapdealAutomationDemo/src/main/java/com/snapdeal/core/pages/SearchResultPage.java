package com.snapdeal.core.pages;

import com.snapdeal.core.BaseClass;
import org.openqa.selenium.By;

public class SearchResultPage extends BaseClass {

    public void findAllElements(){
        driver.findElement(By.xpath("")).click();
        System.out.printf("clicked search");
    }

    public void openHighestPricediPhone(){

    }

}
