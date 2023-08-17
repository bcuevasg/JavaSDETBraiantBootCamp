package com.braiant.selenium.patronesdediseño.testcases;

import org.testng.annotations.Test;

public class TestClass extends BaseTest {

    @Test
    void loginWithRightCredentials() {
        loginPage.verifySchoolName();
    }
}
