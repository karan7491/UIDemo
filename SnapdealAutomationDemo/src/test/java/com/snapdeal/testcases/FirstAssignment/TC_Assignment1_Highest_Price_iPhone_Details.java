package com.snapdeal.testcases.FirstAssignment;

import com.snapdeal.core.BaseClass;
import com.snapdeal.core.pages.HomePage;
import org.testng.annotations.Test;

public class TC_Assignment1_Highest_Price_iPhone_Details extends BaseClass {

    private HomePage homePage;
    public TC_Assignment1_Highest_Price_iPhone_Details(){
        homePage = new HomePage();
    }

    @Test(priority = 2)
    public void searchHighestiPhone() throws InterruptedException {
        homePage.clickOnSearch();
        Thread.sleep(10000);
        System.out.printf("Driver successfully launched");
    }

    public void tearDown(){

    }
}
