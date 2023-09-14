package com.braiant.frameworks.datadriven.testcases.webui;

import com.braiant.frameworks.datadriven.pages.LoginPage;
import com.braiant.frameworks.datadriven.pages.MainPage;
import com.braiant.jdbc.DataBaseInfo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.braiant.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;

public class SchoolLoginWebSQLTest extends BaseWebTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getSQLProviderData(Method method) throws SQLException, IOException {
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getQueryTableArray(DataBaseInfo.DBNAME.dbConn, "validstudents.sql");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getQueryTableArray(DataBaseInfo.DBNAME.dbConn, "invalidstudents.sql");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getSQLProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userData.values().toArray()[0].toString())
                .password(userData.values().toArray()[1].toString())
                .andRememberMe(true)
                .submitLogin();
        //Assert
        actualPage.as(MainPage.class).verifySchoolName();
    }

    @Test(priority = 1, dataProvider = "getSQLProviderData")
    void loginWithWrongCredentials(LinkedHashMap<String, String> userData) {
        actualPage = getInstance(LoginPage.class);

        actualPage.as(LoginPage.class)
                .loginAs(userData.values().toArray()[0].toString())
                .password(userData.values().toArray()[1].toString())
                .andRememberMe(true)
                .submitLogin();

        actualPage = getInstance(LoginPage.class);
        actualPage.as(LoginPage.class).verifyErrorText(userData.values().toArray()[2].toString());
    }
}
