package com.tvt.testcases;

import com.tvt.client.UserApiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiClientTest {
    public static String userName = "testUser" + System.currentTimeMillis();
    @Test
    public void testCreateUser() {
        
        Response response = UserApiClient.createUser(userName);
        System.out.println(response.asString());
        
        Assert.assertEquals(response.getStatusCode(), 200);
        //Assert.assertEquals(response.jsonPath().getString("name"), userName);
    }






































   // @Test
    public void testGetUser() {

        
        // When
        Response response = UserApiClient.getUser(userName);
        
        // Then
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), userName);
    }

   // @Test
    public void testUpdateUser() {
    
        String newEmail = "updated" + System.currentTimeMillis() + "@example.com";
        
        // When
        Response response = UserApiClient.updateUser(userName, newEmail);
        
        // Then
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("email"), newEmail);
    }

    //@Test
    public void testDeleteUser() {
  
        
        // When
        Response response = UserApiClient.deleteUser(userName);
        
        // Then
        Assert.assertEquals(response.getStatusCode(), 204);
    }
} 