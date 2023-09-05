package com.braiant.restassured.demo.testcases;

import com.braiant.baseapi.ServiceFactory;
import com.braiant.restassured.demo.model.resource.ResourceModel;
import com.braiant.restassured.demo.model.resource.ResourcesModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.braiant.baseapi.RestAssuredUtils.getElements;
import static com.braiant.baseapi.ServiceFactory.getResponse;
import static com.braiant.baseapi.ServiceFactory.setEndPoint;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ResourceTest extends BaseTest {
    int id;
    @BeforeMethod
    @Parameters("endpointResources")
    void setupEndPoint(String endpoint) {
        setEndPoint(endpoint);
        actualModel = getInstance(ResourcesModel.class);
        id = actualModel.as(ResourcesModel.class).getData().get(1).getId();
        setEndPoint(endpoint + id);
        response = getResponse();
        actualModel.as(ResourcesModel.class).getData().forEach(System.out::println);
    }

    @Test(priority = 1)
    void verifySingleResource() {
        actualModel = getInstance(ResourceModel.class);
        String resourceName = actualModel.as(ResourceModel.class).getData().getName();
        int resourceYear = actualModel.as(ResourceModel.class).getData().getYear();
        String resourceColor = actualModel.as(ResourceModel.class).getData().getColor();
        String resourcePantone = actualModel.as(ResourceModel.class).getData().getPantoneValue();
        System.out.println(resourceName);
        System.out.println(resourceYear);
        System.out.println(resourceColor);
        System.out.println(resourcePantone);
        assertThat(resourceName, equalTo("fuchsia rose"));
        assertThat(resourceYear, equalTo(2001));
        assertThat(resourceColor, equalTo("#C74375"));
        assertThat(resourcePantone, equalTo("17-2031"));
    }

    @Test(priority = 2)
    void verifyAllResrourcesAreRetrieved() {
        setEndPoint("unknown/");
        actualModel = getInstance(ResourcesModel.class);
        actualModel.as(ResourcesModel.class).getData().forEach(System.out::println);
        System.out.println(actualModel.as(ResourcesModel.class).getData().size());
        assertThat(actualModel.as(ResourcesModel.class).getData().get(2).getColor(), equalTo("#BF1932"));
    }

    @Test(priority = 3)
    void verifyResourceNotFound() {
        setEndPoint("unknown/23");
        ServiceFactory.setResponse(getElements());
        response = ServiceFactory.getResponse();
        assertThat(response.statusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
        System.out.println("Status code is: " + response.statusCode());
    }
}
