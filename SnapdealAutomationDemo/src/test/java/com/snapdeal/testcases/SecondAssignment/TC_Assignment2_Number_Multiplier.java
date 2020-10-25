package com.snapdeal.testcases.SecondAssignment;

import com.snapdeal.core.BaseClass;
import com.snapdeal.core.utils.FileReaderAndWriter;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_Assignment2_Number_Multiplier extends BaseClass {

    public FileReaderAndWriter fileReaderAndWriter;


    public TC_Assignment2_Number_Multiplier(){
        fileReaderAndWriter = new FileReaderAndWriter();
    }

    @Test(priority = 1)
    public void numberMultiplier() throws IOException {
        System.out.println("ran second test case");
        fileReaderAndWriter.readNumbers();
    }

    public void tearDown(){

    }
}
