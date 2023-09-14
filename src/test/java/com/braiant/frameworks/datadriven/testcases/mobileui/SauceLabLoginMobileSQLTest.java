package com.braiant.frameworks.datadriven.testcases.mobileui;

import com.braiant.frameworks.datadriven.screen.HomeScreen;
import com.braiant.frameworks.datadriven.screen.LoginScreen;
import com.braiant.jdbc.DataBaseInfo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static com.braiant.frameworks.datadriven.dataproviders.JSONArrayData.getJsonTableArray;
import static com.braiant.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;

public class SauceLabLoginMobileSQLTest extends BaseMobileTest {
    Object[][] testArray;
    @DataProvider
    public Object[][] getSQLProviderData(Method method) throws SQLException, IOException {
        if (method.getName().equals("loginWithRightCredentials")){
            testArray = getQueryTableArray(DataBaseInfo.DBNAME.dbConn, "validsaucelabusers.sql");
        }

        if (method.getName().equals("loginWithWrongCredentials")){
            testArray = getQueryTableArray(DataBaseInfo.DBNAME.dbConn, "invalidsaucelabusers.sql");
        }

        return testArray;
    }
    @Test(priority = 2,dataProvider = "getSQLProviderData")
    void loginWithRightCredentials(LinkedHashMap<String, String> userData) {
        actualScreen = getInstance(LoginScreen.class);

        actualScreen.as(LoginScreen.class)
                .loginAs(userData.values().toArray()[0].toString())
                .withPassword(userData.values().toArray()[1].toString())
                .submitLogin();

        actualScreen.as(HomeScreen.class).verifyProductsText();
    }

    @Test(priority = 1, dataProvider = "getSQLProviderData")
    void loginWithWrongCredentials(LinkedHashMap<String, String> userData) {
        actualScreen = getInstance(LoginScreen.class);

        actualScreen.as(LoginScreen.class)
                .loginAs(userData.values().toArray()[0].toString())
                .withPassword(userData.values().toArray()[1].toString())
                .submitLogin();

        actualScreen = getInstance(LoginScreen.class);
        String errorMessage = actualScreen.as(LoginScreen.class).getError();

        if (errorMessage.toLowerCase().contains("password") || errorMessage.toLowerCase().contains("username")){
            actualScreen.as(LoginScreen.class).verifyErrorText(userData.values().toArray()[3].toString());
        }else {
            actualScreen.as(LoginScreen.class).verifyErrorText(userData.values().toArray()[2].toString());
        }
    }
}
