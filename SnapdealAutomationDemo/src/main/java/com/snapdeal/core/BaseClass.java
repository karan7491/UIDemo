package com.snapdeal.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver = null;
    public static String curDir = System.getProperty("user.dir");;
    public HashMap<String,String> prop = null;

    public BaseClass(){
        this.prop = propertiesLoader();
    }

    public HashMap<String, String> getProp() {
        return prop;
    }

    public HashMap<String,String> propertiesLoader() {
        HashMap<String,String> propHmap = new HashMap<>();
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

    public void initDriver(){
        if(driver==null){
            System.setProperty("webdriver.chrome.driver",curDir+"\\Driver\\chromedriver.exe" );
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            driver = new ChromeDriver(chromeOptions);
            System.out.printf("Browser initiated!!!!");
        }else {
            System.out.printf("Browser already initiated!!!!");
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void suitSetup() {
        initDriver();
        driver.get(prop.get("URL"));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterSuite(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
