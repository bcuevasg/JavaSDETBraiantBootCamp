package com.braiant.frameworks.datadriven.testcases.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.braiant.frameworks.datadriven.dataproviders.ExcelArrayData.getExcelTableArray;

public class ExcelExample {
    @DataProvider
    public Object[][] getExcelProviderData() throws IOException {
        return getExcelTableArray("webusers.xlsx","invalidUsers");
    }

    @Test(dataProvider = "getExcelProviderData")
    public void testJson(LinkedHashMap<Object,Object> data) {
        data.forEach((key, value) -> {
            System.out.printf("Colum: %s and Value: %s\n", key, value);
        });
    }
}
