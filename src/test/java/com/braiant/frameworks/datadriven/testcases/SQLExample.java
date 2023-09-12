package com.braiant.frameworks.datadriven.testcases;

import jdbc.DataBaseInfo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.braiant.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;

public class SQLExample {
    @DataProvider
    public Object[][] getSQLProviderData() throws SQLException, IOException {
        return getQueryTableArray(DataBaseInfo.DBNAME.dbConn, "studentdetail.sql");
    }

    @Test(dataProvider = "getSQLProviderData")
    public void sqlTest(LinkedHashMap<Object,Object> data){
        data.forEach((key, value) -> {
            System.out.println();
        }
    }
}
