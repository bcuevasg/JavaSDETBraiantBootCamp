package com.braiant.frameworks.datadriven.testcases.api;

import com.braiant.baseapi.ServiceFactory;
import com.braiant.frameworks.datadriven.models.user.UserModel;
import com.braiant.frameworks.datadriven.models.user.UsersModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

import static com.braiant.baseapi.RestAssuredUtils.deleteElement;
import static com.braiant.baseapi.RestAssuredUtils.putWithBody;
import static com.braiant.baseapi.ServiceFactory.getResponse;
import static com.braiant.baseapi.ServiceFactory.setEndPoint;
import static com.braiant.frameworks.datadriven.dataproviders.SQLArrayData.getQueryTableArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ResreqUserSQLTest extends BaseApiTest {
    int id;

    @DataProvider
    public Object[][] getSQLProviderData() throws SQLException, IOException {
        return getQueryTableArray("resreq", "resrequsers.sql");
    }
    @BeforeMethod
    @Parameters("endpoint")
    void setupEndPoint(String endpoint) {
        setEndPoint(endpoint);
        actualModel = getInstance(UsersModel.class);
        id = actualModel.as(UsersModel.class).getData().get(1).getId();
        setEndPoint(endpoint + id);
        response = getResponse();
        actualModel.as(UsersModel.class).getData().forEach(System.out::println);
    }

    @Test(priority = 1)
    void verifySingleUserIsRetrieved() {

        actualModel = getInstance(UserModel.class);
        String userFirstName = actualModel.as(UserModel.class).getData().getFirstName();
        System.out.println(userFirstName);
        assertThat(userFirstName, equalTo("Janet"));
    }

    @Test(priority = 2, dataProvider = "getSQLProviderData")
    void verifyUserIsUpdated(LinkedHashMap<String,String> updateUser) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM");//"uuuu-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        ServiceFactory.setResponse(putWithBody(updateUser));
        response = ServiceFactory.getResponse();
        String updatedAt = response.body().jsonPath().get("updatedAt").toString();

        System.out.println(updatedAt);
        assertThat(response.statusCode(), equalTo(HttpStatus.SC_OK));

        assertThat(updatedAt, containsString(dtf.format(now)));
    }

    @Test(priority = 3)
    void verifyUserIsDeleted() {
        ServiceFactory.setResponse(deleteElement());
        response = ServiceFactory.getResponse();

        assertThat(response.statusCode(), equalTo(HttpStatus.SC_NO_CONTENT));

    }

    @Test(priority = 4)
    void verifyAllUsersAreRetrieved() {
        setEndPoint("users/");
        actualModel = getInstance(UsersModel.class);
        actualModel.as(UsersModel.class).getData().forEach(System.out::println);
        System.out.println(actualModel.as(UsersModel.class).getData().size());
        assertThat(actualModel.as(UsersModel.class).getData().get(2).getFirstName(), equalTo("Emma"));
    }
}
