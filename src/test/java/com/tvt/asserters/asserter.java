package com.tvt.asserters;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

public class Asserter {
    
    @Step("Verify status code is {expectedStatusCode}")
    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, 
            "Expected status code: " + expectedStatusCode + " but got: " + response.getStatusCode());
    }

    @Step("Verify response contains username: {expectedUsername}")
    public static void assertUsername(Response response, String expectedUsername) {
        String actualUsername = response.jsonPath().getString("username");
        Assert.assertEquals(actualUsername, expectedUsername, 
            "Expected username: " + expectedUsername + " but got: " + actualUsername);
    }

    @Step("Verify response contains email: {expectedEmail}")
    public static void assertEmail(Response response, String expectedEmail) {
        String actualEmail = response.jsonPath().getString("email");
        Assert.assertEquals(actualEmail, expectedEmail, 
            "Expected email: " + expectedEmail + " but got: " + actualEmail);
    }
}
