package api.settings;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.*;
import io.restassured.specification.*;


public class ConfigSteps {
    protected static RequestSpecification requestSpecification;
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification setUpRequestSpecifivation(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setRelaxedHTTPSValidation()
                .addFilter(new AllureRestAssured())
                .setContentType("application/json")
                .setAccept("application/json")
                .log(LogDetail.ALL)
                .build();

    }

    public static ResponseSpecification responseSpecStatusCode(int code) {
        return  new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

    public static void installSpecification( RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

}
