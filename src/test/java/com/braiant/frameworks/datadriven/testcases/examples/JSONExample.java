package com.braiant.frameworks.datadriven.testcases.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static com.braiant.frameworks.datadriven.dataproviders.JSONArrayData.getJsonTableArray;

public class JSONExample {
    @DataProvider
    public Object[][] getJSONProviderData(){
        return getJsonTableArray("webusers.json","invalidUsers");
    }

    @Test(dataProvider = "getJSONProviderData")
    public void testJson(LinkedHashMap<Object,Object> data) {
        data.forEach((key, value) -> {
            System.out.printf("Colum: %s and Value: %s\n", key, value);
        });
    }
}
