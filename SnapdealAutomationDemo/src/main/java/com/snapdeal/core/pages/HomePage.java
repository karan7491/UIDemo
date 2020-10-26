package com.snapdeal.core.pages;

import com.snapdeal.core.BaseClass;
import org.openqa.selenium.By;

public class HomePage extends BaseClass {

    public void clickOnSearch(){
        driver.findElement(By.xpath("//*[@id=\"inputValEnter\"]")).isDisplayed();
        driver.findElement(By.id("inputValEnter")).isEnabled();
        driver.findElement(By.id("inputValEnter")).click();
    }

    public void enterSearchKey(String key){

        driver.findElement(By.id("inputValEnter")).sendKeys(key);
        System.out.printf("Entered product for search.");
    }

    public void clickOnSearchSubmitButton(){
        driver.findElement(By.xpath("")).click();
        System.out.printf("Enter search button.");
    }
}
