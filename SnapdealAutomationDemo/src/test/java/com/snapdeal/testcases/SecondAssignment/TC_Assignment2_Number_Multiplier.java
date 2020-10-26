package com.snapdeal.testcases.SecondAssignment;

import com.snapdeal.core.BaseClass;
import com.snapdeal.core.utils.FileReaderAndWriter;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_Assignment2_Number_Multiplier extends BaseClass {

    @Test(priority = 2)
    public void numberMultiplier() throws IOException {
        FileReaderAndWriter fileReaderAndWriter = new FileReaderAndWriter();
        int[] resultArray = fileReaderAndWriter.readNumbers();
        System.out.println("Numbers reading and multiplication with desired number completed.");

        System.out.println("Numbers stored in result Array: \n");

        for (int i=0; i<resultArray.length; i++){
            if(resultArray[i]!=0)
                System.out.println("ResultArrayElement_"+i+":" +resultArray[i]);
        }

        fileReaderAndWriter.writeNumbers(resultArray);
        System.out.println("\nResult array numbers written successfully to the result.txt file.");
    }
}
