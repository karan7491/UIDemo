package com.snapdeal.core.pages;

import com.snapdeal.core.BaseClass;
import org.openqa.selenium.By;

public class ItemDetailsPage extends BaseClass {

    public String getTitle(){
        String title = "";
        driver.findElement(By.xpath("//*[@id=\"productOverview\"]/div[2]/div/div[1]/div[1]/div[1]/h1")).getText();
    return title;
    }

    public String imgLink1(){
        String title = "";
        driver.findElement(By.xpath("//*[contains(@)abc, '']")).getText();
        return title;
    }

    public String imgLink2(){
        String title = "";
        driver.findElement(By.xpath("//*[contains(@)abc, '']")).getText();
        return title;
    }
}
