package com.snapdeal.core.utils;

import com.snapdeal.core.BaseClass;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class FileReaderAndWriter extends BaseClass {

    private File inputFile = new File(curDir+"\\TestData\\input.txt");
    private File outputFile = new File(curDir+"\\result.txt");


    public void readNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        String splitRegex = "|";
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            String[] numbers = line.split(splitRegex);
            System.out.println(numbers);
        }
    }

    public static void writeNumbers(){

    }

}
