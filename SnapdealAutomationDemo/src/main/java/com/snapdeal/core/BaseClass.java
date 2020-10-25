package com.snapdeal.core;

import com.snapdeal.core.utils.FileReaderAndWriter;
import com.snapdeal.core.utils.GlobalDataLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.HashMap;

public class BaseClass {

    protected WebDriver driver = null;
    public static String curDir = null;
    public HashMap<String,String> prop = null;
    public String baseURL = null;

    public void propLoader(){
        prop = GlobalDataLoader.propertiesLoader();
        baseURL = prop.get("URL");
    }

    public void initDriver(){
        if(driver==null){
            curDir = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver",curDir+"\\Driver\\chromedriver.exe" );
            driver = new ChromeDriver();
            System.out.printf("Browser initiated!!!!");
        }else {
            System.out.printf("Browser already initiated!!!!");
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void suitSetup(){
        initDriver();
        propLoader();
        new WebDriverWait(driver,50000);
        driver.get(baseURL);
        driver.manage().window().fullscreen();
    }

    @AfterSuite(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
