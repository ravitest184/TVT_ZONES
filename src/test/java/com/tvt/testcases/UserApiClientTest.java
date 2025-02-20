package com.tvt.testcases;

import com.tvt.base.Base;
import com.tvt.asserters.Asserter;
import com.tvt.client.UserApiClient;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Pet Store API Testing")
@Feature("User Management")
public class UserApiClientTest extends Base {
    private static String userName;
    private static String userEmail;

    @BeforeClass
    public void setUp() {
        userName = "testUser"; //+ System.currentTimeMillis();
        userEmail = userName + "@example.com";
    }

    @Test(priority = 1)
    @Story("Create User")
    @Description("Test to create a new user in the system")
    @Severity(SeverityLevel.BLOCKER)
    public void testCreateUser() {
        Response response = UserApiClient.createUser(userName);
        
        Asserter.assertStatusCode(response, 200);
        saveStepLog("User created successfully with username: " + userName);
    }

    @Test(priority = 2)
    @Story("Get User")
    @Description("Test to retrieve user details")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetUser() {
        Response response = UserApiClient.getUser("testUser");
        
        Asserter.assertStatusCode(response, 200);
        Asserter.assertUsername(response, userName);
        saveStepLog("User retrieved successfully");
    }

    @Test(priority = 3)
    @Story("Update User")
    @Description("Test to update user email")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdateUser() {
        String newEmail = "updated" + System.currentTimeMillis() + "@example.com";
        Response response = UserApiClient.updateUser(userName, newEmail);
        
        Asserter.assertStatusCode(response, 200);
        saveStepLog("User updated successfully with new email: " + newEmail);
    }

    @Test(priority = 4)
    @Story("Delete User")
    @Description("Test to delete user from the system")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUser() {
        Response response = UserApiClient.deleteUser(userName);
        
        Asserter.assertStatusCode(response, 200);
        saveStepLog("User deleted successfully");
    }

    @Step("{0}")
    private void saveStepLog(String message) {
        // This method is used to log steps in Allure report
    }
} 