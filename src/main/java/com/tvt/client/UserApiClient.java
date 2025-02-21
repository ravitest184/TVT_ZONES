package com.tvt.client;
import com.tvt.builder.user.CreateUserBuilder;
import com.tvt.utils.EndpointReader;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//import com.tvt.*;

public class UserApiClient {

    private static final String CREATE_USER_PATH = EndpointReader.getValueFromJson("user.post_url");
    private static final String GET_USER_PATH = EndpointReader.getValueFromJson("user.get_url");;
    private static final String UPDATE_USER_PATH = EndpointReader.getValueFromJson("user.update_url");
    private static final String DELETE_USER_PATH = EndpointReader.getValueFromJson("user.delete_url");
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static Response createUser(String name) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(CreateUserBuilder.createUserBuilder(name))
        .when()
            .post(BASE_URL + "/user");
    }

    public static Response getUser(String username) {
        return given()
            .contentType(ContentType.JSON)
            .pathParam("username", username)
        .when()
            //.get("https://petstore.swagger.io/v2/user/{username}");
            .get(GET_USER_PATH);
    }

    public static Response updateUser(String username, String email) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(CreateUserBuilder.UpdateUserBuilder(email))
            .pathParam("username", username)
        .when()
            .put(UPDATE_USER_PATH);
    }

    public static Response deleteUser(String username) {
        return given()
            .contentType(ContentType.JSON)
            .pathParam("username", username)
        .when()
            .delete(DELETE_USER_PATH);
    }
}
