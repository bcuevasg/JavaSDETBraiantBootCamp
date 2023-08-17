package com.braiant.selenium.patronesdediseño.testcases;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentTest extends BaseTest {
    String[] studentPersonaDetails = {"Female","TestStudentName","TestStudentLastName","12","Mexico"
            ,"Test Address"};

    Map<String, String> studentAccountInfo = new HashMap<>();
    @Test
    void verifyNewStudentCreated(){
        studentAccountInfo.put("email", "test" + Math.random() + "@gmail.com");
        studentAccountInfo.put("user", "testuser");
        studentAccountInfo.put("password", "test123");


        menuPage.clickStudentsAccess();
        studentPage.clickCreateNew();
        studentPage.studentPersonalDetails(studentPersonaDetails);
        studentPage.accountInformation(studentAccountInfo);
        studentPage.schoolDetails("B-0012");
        studentPage.validateStudentIsAdded(studentPersonaDetails[1]);

    }
}
