package com.snapdeal.core.utils;

import org.openqa.selenium.WebElement;
import java.util.Iterator;
import java.util.List;

public class BasicUtilities {

    public int filterHighestPricediPhone(List<WebElement> elements){
        int price = 0;
        int temp;
        Iterator<WebElement> iterator = elements.listIterator();
        while (iterator.hasNext()){
            String x = iterator.next().getText().split(". ")[1];
            if(x.contains(",")){
                temp = Integer.valueOf(x.split(",")[0]+x.split(",")[1]);
            }else {
                temp = Integer.valueOf(x);
            }

            if(temp>price)
                price=temp;
        }
        return price;
    }
}
