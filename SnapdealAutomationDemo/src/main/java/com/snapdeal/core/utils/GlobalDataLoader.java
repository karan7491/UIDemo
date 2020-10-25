package com.snapdeal.core.utils;

import com.snapdeal.core.BaseClass;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class GlobalDataLoader extends BaseClass {

    public static HashMap<String,String> propertiesLoader() {
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
}
