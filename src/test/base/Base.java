package com.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;
import java.io.InputStream;
import java.util.Properties;

public class Base {
    private static String baseUrl;

    @BeforeSuite
    public void setup() {
        // Configure RestAssured with logging and Allure reporting
        RestAssured.filters(
            new AllureRestAssured(),
            new RequestLoggingFilter(),
            new ResponseLoggingFilter()
        );
        RestAssured.baseURI = getBaseUrl();
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            try {
                Properties properties = new Properties();
                InputStream inputStream = Base.class.getClassLoader().getResourceAsStream("config.properties");
                if (inputStream != null) {
                    properties.load(inputStream);
                    baseUrl = properties.getProperty("base.url", "https://petstore.swagger.io/v2");
                    inputStream.close();
                }
            } catch (java.io.IOException e) {
                baseUrl = "https://petstore.swagger.io/v2"; // Default fallback
            }
        }
        return baseUrl;
    }
}




