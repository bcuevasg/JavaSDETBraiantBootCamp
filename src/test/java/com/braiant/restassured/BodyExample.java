package com.braiant.restassured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class BodyExample {
    private static final String BASE_URL = "https://api.github.com/";
    private static final String REQRES_BASE_URL = "https://reqres.in/api/";
    Response response;

    @BeforeTest
    void setup(){
        response = RestAssured.get(BASE_URL + "rate_limit");
    }

    @Test
    void jsonPathReturnsMap(){
        ResponseBody<?> body = response.body();
        JsonPath jsonPath = response.body().jsonPath();
        JsonPath jsonPath2 =response.body().jsonPath();

        Map<String,String> fullJson = jsonPath2.get();
        Map<String,String> subMap = jsonPath2.get("resources");
        Map<String,String> subMap2 = jsonPath2.get("resources.graphhql.remaining");

        int coreLimit = jsonPath.get("resources.core.limit");
        int graphhqlRemaining = jsonPath.get("resources.graphql.limit");

        System.out.println(fullJson);
        System.out.println(subMap);
        System.out.println(subMap2);
        System.out.println(coreLimit);
        System.out.println(graphhqlRemaining);

        Assert.assertEquals(coreLimit,60);
        Assert.assertEquals(graphhqlRemaining,0);
    }

    @Test
    void castingFailure(){
        JsonPath jsonPath = RestAssured.get(BASE_URL + "rate_limit").body().jsonPath();
        Map<String,String> isNull = jsonPath.get("incorrect.paterwerh");//deberia mandar error ya que el valor puede no venir
        int aMap = jsonPath.get("resources.core");
        Assert.assertNotNull(isNull);
    }

    @Test
    void matcherExample(){
        RestAssured.get(BASE_URL)
                .then()
                .body("current_user_url", equalTo(BASE_URL + "user"))
                .body(containsString("feeds_url")) // buscara solo feeds url body response
                .body(containsString("feeds_url"),
                        containsString("current_user_authorizations_html_url"));// encontrara muiltiples varios valores
    }

    @Test
    void complexBodyExample(){
        RestAssured.get(BASE_URL +"users/mojombo")
                .then()
                .body("url", res-> containsString("mojombo"))
                .body("html_url",res-> containsString(res.body().jsonPath().get("login")));
    }
    @DataProvider
    Object [][] users(){
        return new Object[][]{
                {"mojombo"},
                {"defunkt"},
                {"pjhyett"},
                {"wycats"}
        };
    }
    @Test(dataProvider = "users")
    void complexBodyWithDpExample(String user) {
        RestAssured.get(BASE_URL + "users/" + user)
                .then()
                .body("html_url", res -> containsString(res.body().jsonPath().get("login")));
    }

    @Test
    void nestedBodyExample(){
        //sin root path
        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .body("resources.core.limit", equalTo(60))
                .body("resources.core.remaining", lessThanOrEqualTo(60))
                .body("resources.core.reset", notNullValue());

        //con root paht arroar texto
        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60))
                    .body("remaining", lessThanOrEqualTo(60))
                    .body("reset", notNullValue())
                .rootPath("resources.search")// accesde al nodo que querramos abrir
                    .body("limit",equalTo(10))
                    .body("remaining", lessThanOrEqualTo(10))
                .noRootPath()
                    .body("rate.limit", is(60));
    }

    @Test
    void repeatingItems(){
        RestAssured.get(REQRES_BASE_URL + "users?page=1")
                .then()
                //.body("data.id", equalTo(1) )// Esta line fallara ya que encontrara multiples valores dentro del id (arrary)
                .body("data.id[0]", equalTo(1) )
                .body("data.id[1]", equalTo(2) )
                .body("data.first_name[2]", equalTo("Emma") )
                .body("data.first_name[3]", equalTo("Eve") )
                //.body("data.first_name", containsInAnyOrder("Eve","Emma"))esta linea fallara ya que recibimos un arreglo con mas valores
                .body("data.first_name", hasItem("Eve"))
                .body("data.first_name", hasItem(endsWith("mma")));
    }

    @Test
    void parseAndSynctacticSuggar(){
        RestAssured.get(BASE_URL)
                .then()
                .using()
                    .defaultParser(Parser.JSON)
                .body("current_user_url", equalTo(BASE_URL + "user"));
    }

}
