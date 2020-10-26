package com.snapdeal.testcases.FirstAssignment;

import com.snapdeal.core.BaseClass;
import com.snapdeal.core.pages.HomePage;
import com.snapdeal.core.pages.SearchResultPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_Assignment1_Highest_Price_iPhone_Details extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    public TC_Assignment1_Highest_Price_iPhone_Details(){
        homePage = new HomePage();
    }
    @BeforeTest(alwaysRun = true)
    public void launchOpenSD() throws InterruptedException {
        driver.get(prop.get("URL"));
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void searchHighestiPhone() throws InterruptedException {

        homePage.clickOnSearch();
        System.out.printf("\nClicked on search box.");
        homePage.enterSearchKey("iPhone");
        System.out.printf("\nEnter search value as iPhone.");
        homePage.clickOnSearchSubmitButton();
        System.out.printf("\nPress enter for searching");

        Thread.sleep(10000);

        searchResultPage = new SearchResultPage();
        searchResultPage.findAllElements();

    }
    @AfterTest
    public void tearDown(){
    quitBrowser();
    }
}
