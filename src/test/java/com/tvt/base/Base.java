package com.tvt.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

public class Base {
    @BeforeSuite
    public void setup() {
        RestAssured.filters(
            new AllureRestAssured(),
            new RequestLoggingFilter(),
            new ResponseLoggingFilter()
        );
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
} 