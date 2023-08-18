package com.braiant.restassured;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.number.OrderingComparison;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HeadersExample {
    private static final String BASE_URL = "https://api.github.com";

    Response response;

    @BeforeTest
    void setup(){
        response = RestAssured.get(BASE_URL);
    }
    @Test
    void verifyGenericHeader(){
        assertThat(response.getHeader("server"), equalTo("GitHub.com"));
        assertThat(response.getHeader("x-ratelimit-limit"), equalTo("60"));
        assertThat(Integer.parseInt(response.getHeader("x-ratelimit-limit")),equalTo(60));
    }

    @Test
    void verifyGetHeders(){
        Headers headers = response.getHeaders();
        String headerOne = headers.getValue("x-github-media-type");
        System.out.println("The value iof header 1 is " + headerOne);
        int headerSize = headers.size();
        System.out.println("I have the next amount of headers: " + headerSize);
        List<Header> headerList = headers.asList();
        //headerList.forEach(System.out::println);
        boolean headerIspresent = headers.hasHeaderWithName("header2");
        Assert.assertTrue(!headerIspresent, "Header is not present");// el "!" volvera el valor positivo por eso no marca error
    }

    @Test
    void verifyResponseTime(){
        System.out.println(response.time());
        System.out.println(response.getTime());
        System.out.println(response.timeIn(TimeUnit.MICROSECONDS));
        System.out.println(response.getTimeIn(TimeUnit.MICROSECONDS));
    }
    @Test
    void basicValidate(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("x-ratelimit-limit", "60");
    }

    @Test
    void basicValidateSuggar(){
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and().assertThat()
                .header("x-ratelimit-limit", "60");
    }

    @Test
    void simpleHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(equalTo(200))
                .statusCode(lessThan(300))
                .statusCode(anyOf(equalTo(200), equalTo(201)))
                .header("cache-control",containsString("max-age=60"))
                .time(lessThan(2L), TimeUnit.SECONDS)
                .header("etag", is(emptyString()));
    }

    @Test
    void complexHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .header("x-ratelimit-limit",Integer::parseInt, equalTo(60))
                //.header("date", date -> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME),
                //        OrderingComparison.comparesEqualTo(LocalDate.now()))// falla esta line debido a que la fecha obtenida es de otro servidor
                .header("x-ratelimit-limit", res-> greaterThan(res.header("x-ratelimit-remaining")));
    }

    @Test
    void usingMappsToTestHeaders(){
        Map<String,String> expectedHeaders =Map.of("content-encoding","gzip","access-control-allow-origin","*");

        RestAssured.get(BASE_URL)
                .then()
                .headers("content-encoding","gzip","access-control-allow-origin","*",
                        "cache-control", containsString("public"));

        RestAssured.get(BASE_URL)
                .then()
                .headers(expectedHeaders);
    }


}
