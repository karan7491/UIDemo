package com.snapdeal.core.pages;

import com.snapdeal.core.BaseClass;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {

    public void clickOnSearch(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("inputValEnter")).isDisplayed();
        driver.findElement(By.id("inputValEnter")).isEnabled();
        driver.findElement(By.id("inputValEnter")).click();
    }
    public void enterSearchKey(String key){

        driver.findElement(By.id("inputValEnter")).sendKeys(key);
        System.out.printf("\nEntered product for search.");
    }

    public void clickOnSearchSubmitButton(){
        driver.findElement(By.xpath("//button[contains(@class,'searchformButton col-xs-4 rippleGrey')]")).click();
        System.out.printf("\nEnter search button.");
    }

}
