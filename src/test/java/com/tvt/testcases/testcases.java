package com.tvt.testcases;

import org.testng.annotations.Test;
import com.tvt.builder.CreateUserBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class testcases {



    @Test
    public void createUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RequestSpecification request = RestAssured.given();

        String response=request.body(CreateUserBuilder.createUserBuilder("jd"))
        .contentType(ContentType.JSON)
        .when()
        .post("user")
        .then()
        .statusCode(200).extract().response().asString();

        System.out.println("jwebhhevfgdewgyfvghdwvhcdvhgfvgh");
    }
    @Test
    public void getUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user/";
        RequestSpecification request = RestAssured.given();

        request
        .when()
        .get("jd")
        .then().log().all()
        .statusCode(200);
    }
}
