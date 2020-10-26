package com.snapdeal.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static String curDir = System.getProperty("user.dir");;
    public HashMap<String,String> prop = null;

    public BaseClass(){
        this.prop = propertiesLoader();
    }

    public HashMap<String, String> getProp() {
        return prop;
    }

    public HashMap<String,String> propertiesLoader() {
        HashMap<String,String> propHmap = new HashMap();
        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(curDir + "\\src\\main\\resources\\config.properties"));
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        try {
            prop.load(inputStream);
            Enumeration enumeration = prop.propertyNames();
            while (enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String value = prop.getProperty(key);
                propHmap.put(key,value);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return propHmap;
    }

    public static void initDriver(){
        if(driver==null){
            System.setProperty("webdriver.chrome.driver",curDir+"\\Driver\\chromedriver.exe" );
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.setHeadless(true);
            driver = new ChromeDriver(chromeOptions);
            System.out.printf("Browser initiated!!!!");
        }else {
            System.out.printf("Browser already initiated!!!!");
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void suitSetup() throws InterruptedException {
        initDriver();
        WebDriverWait wt= new WebDriverWait(driver,40);
    }
    public void quitBrowser(){
        driver.quit();
    }
}
