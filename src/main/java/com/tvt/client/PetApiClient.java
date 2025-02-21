package com.tvt.client;

import com.tvt.dto.Pet.CreatePet;
import com.tvt.utils.EndpointReader;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetApiClient {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String CREATE_PET_PATH = EndpointReader.getValueFromJson("pet.post_url");
    private static final String GET_PET_PATH = EndpointReader.getValueFromJson("pet.get_url");
    private static final String UPDATE_PET_PATH = EndpointReader.getValueFromJson("pet.update_url");
    private static final String DELETE_PET_PATH = EndpointReader.getValueFromJson("pet.delete_url");

    public static Response createPet(CreatePet payload) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post(BASE_URL + "/pet");
    }

    public static Response getPet(int petId) {
        return given()
            .contentType(ContentType.JSON)
            .pathParam("petId", petId)
        .when()
            .get(GET_PET_PATH);
    }

    public static Response updatePet(CreatePet payload) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .put(UPDATE_PET_PATH);
    }

    public static Response deletePet(int petId) {
        return given()
            .contentType(ContentType.JSON)
            .pathParam("petId", petId)
        .when()
            .delete(DELETE_PET_PATH);
    }
}
