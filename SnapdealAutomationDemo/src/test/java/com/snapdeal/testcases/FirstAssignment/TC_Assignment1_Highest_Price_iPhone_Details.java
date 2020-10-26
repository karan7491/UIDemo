package com.snapdeal.testcases.FirstAssignment;

import com.snapdeal.core.BaseClass;
import com.snapdeal.core.pages.HomePage;
import com.snapdeal.core.pages.ItemDetailsPage;
import com.snapdeal.core.pages.SearchResultPage;
import com.snapdeal.core.utils.BasicUtilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class TC_Assignment1_Highest_Price_iPhone_Details extends BaseClass {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private BasicUtilities basicUtilities;

    public TC_Assignment1_Highest_Price_iPhone_Details(){
        homePage = new HomePage();
        basicUtilities = new BasicUtilities();
    }

    @BeforeTest(alwaysRun = true)
    public void launchSD() throws InterruptedException {
        driver.get(prop.get("URL"));
        driver.manage().window().fullscreen();
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
        List<WebElement> elements=searchResultPage.findAllElements();

        int price = basicUtilities.filterHighestPricediPhone(elements);
        System.out.println("\nHighest price of listed items: "+price);

        searchResultPage.clickOnHighestPricedPhone(price);
        System.out.println("\nOpened highest priced item.");

        Thread.sleep(10000);

        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        String title = itemDetailsPage.getTitle();
        System.out.println("\nTitle: "+title);

    }
    @AfterTest
    public void tearDown(){
    quitBrowser();
    }
}
