package com.snapdeal.core.utils;

import com.snapdeal.core.BaseClass;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileReaderAndWriter extends BaseClass {

    private File inputFile = new File(curDir+"\\TestData\\input.txt");
    private File outputFile = new File(curDir+"\\result.txt");
    private File pruductDetailsFile = new File(curDir+"\\itemDetails.txt");
    private int numbersPerRow = 0;
    private int multiplier = 0;
    private int numberOfLine = 0;
    public HashMap<String,String> prop = getProp();


    public int[] readNumbers() throws IOException {
        System.out.println(prop);
        numbersPerRow = Integer.valueOf(prop.get("numbersPerRow"));
        multiplier = Integer.valueOf(prop.get("multiplier"));
        int[] allNumbers = new int[100];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        String splitRegex = "|";
        String line = "";
        int k = 0;
        while ((line = bufferedReader.readLine())!=null){
            numberOfLine ++;
            System.out.println(line);
            String[] numbers = line.split("\\|",numbersPerRow);
            for (int i=0;i<numbers.length; i++){
                int arr = Integer.valueOf(numbers[i]) * multiplier;
                allNumbers[i+k]=arr;
                System.out.println(arr);
            }
            k = k + numbersPerRow;
        }
        bufferedReader.close();
        return allNumbers;
    }

    public void writeNumbers(int[] numbersArray) throws IOException {
        BufferedWriter bufferedWriter = null;
        int temp;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i< numbersArray.length; i++) {
            try {
                temp = numbersArray[i];
                if(temp!=0)
                bufferedWriter.write(String.valueOf(temp )+"|");

                if(i+1 == numbersPerRow) {
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bufferedWriter.close();
    }

    public void writeProductDetails(HashMap<String,String> parameters)  throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(pruductDetailsFile));
            Set<String> keys =parameters.keySet();
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()){
                bufferedWriter.write(iterator.next()+" : "+parameters.get(iterator.next()));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter.close();
    }
}

