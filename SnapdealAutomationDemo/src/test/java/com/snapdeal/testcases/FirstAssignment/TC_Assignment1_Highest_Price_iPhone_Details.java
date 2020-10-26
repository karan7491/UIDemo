package com.snapdeal.testcases.FirstAssignment;

import com.snapdeal.core.BaseClass;
import com.snapdeal.core.pages.HomePage;
import com.snapdeal.core.pages.SearchResultPage;
import org.testng.annotations.Test;

public class TC_Assignment1_Highest_Price_iPhone_Details extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    public TC_Assignment1_Highest_Price_iPhone_Details(){
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void searchHighestiPhone() throws InterruptedException {

        homePage.clickOnSearch();
        System.out.printf("Clicked on search box.");
        homePage.enterSearchKey("iPhone");
        System.out.printf("Enter search value as iPhone.");
        homePage.clickOnSearchSubmitButton();
        System.out.printf("Press enter for searching");

        searchResultPage = new SearchResultPage();

    }

    public void tearDown(){

    }
}
