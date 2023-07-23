package com.braiant.testNG.dataprovider;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestData {
    @DataProvider(name = "SchoolProvider")
    Object[][] getSchoolData(){
        return new Object[][]{
                {"Gil", "Braiant", "Luis", "Daniel"},
                {"Jimena", "Jennifer", "Luisa", "Maria"},
                {"User1", "User2", "User3", "User4"}
        };
    }

    @DataProvider
    Object[][] getBookData(ITestContext groupItest){
        Object[][] groupArray = null;
        for(String group:groupItest.getIncludedGroups()){
            if(group.equals("Smoke")){
                groupArray = new Object[][]{
                        {"East of Eden", "John Steinbeck", "1952", "Novel"},
                        {"The House of Mirt", "Edith Wharton", "1905", "Novel"},
                        {"Rosemary and Rue", "Seanan Mcguarie", "No Data", "Poem"},
                        {"The Dark Tower", "Stephen King", "1852", "Thriller"}
                };
                break;
            } else if (group.equals("Regression")) {
                groupArray = new Object[][]{
                        {"East of Eden", "John Steinbeck", },
                        {"The House of Mirt", "Edith Wharton"}
                };
            } break;
        }
        return groupArray;
    }

    @DataProvider
    Object[][] getBookMethodData(Method method) {
        if (method.getName().equals("verifyBookCompleteInfo")) {
            return new Object[][]{
                    {"East of Eden", "John Steinbeck", "1952", "novela"},
                    {"The House of Mirth", "Edith Wharton", "1905", "novela"},
                    {"Rosemary and Rue", "Seanan Mcguire", "no data", "poema"},
                    {"The Dark Tower", "Stephen King", "1852", "Triller"}
            };
        } else if (method.getName().equals("verifyBookNameAndAuthor")) {
            return new Object[][]{
                    {"East of Eden", "John Steinbeck"},
                    {"The House of Mirth", "Edith Wharton"}
            };
        }
        return null;
    }

}
