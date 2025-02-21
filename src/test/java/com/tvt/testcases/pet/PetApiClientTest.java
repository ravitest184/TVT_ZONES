package com.tvt.testcases.pet;

import com.tvt.base.Base;
import com.tvt.asserters.Asserter;
import com.tvt.client.PetApiClient;
import com.tvt.builder.pet.PetBuilder;
import com.tvt.dto.Pet.CreatePet;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Pet Store API Testing")
@Feature("Pet Management")
public class PetApiClientTest extends Base {
    private static CreatePet pet;
    private static int petId;

    @BeforeClass
    public void setUp() {
        pet = PetBuilder.createPetBuilder(400,"Available");
        petId = pet.getId();
    }

    @Test(priority = 1)
    @Story("Create Pet")
    @Description("Test to create a new pet in the store")
    @Severity(SeverityLevel.BLOCKER)
    public void testCreatePet() {
        Response response = PetApiClient.createPet(pet);
        
        Asserter.assertStatusCode(response, 200);
        saveStepLog("Pet created successfully with ID: " + petId);
    }

    @Test(priority = 2)
    @Story("Get Pet")
    @Description("Test to retrieve pet details")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetPet() {
        Response response = PetApiClient.getPet(petId);
        Asserter.assertStatusCode(response, 200);
        Asserter.assertJsonPath(response, "id", petId);
        saveStepLog("Pet retrieved successfully");
    }

    @Test(priority = 3)
    @Story("Update Pet")
    @Description("Test to update pet status")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdatePet() {
        CreatePet updatedPet = PetBuilder.updatePetBuilder("sold");
        Response response = PetApiClient.updatePet(updatedPet);
        
        Asserter.assertStatusCode(response, 200);
        Asserter.assertJsonPath(response, "status", "sold");
        saveStepLog("Pet updated successfully with new status: sold");
    }

    @Test(priority = 4)
    @Story("Delete Pet")
    @Description("Test to delete pet from the store")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeletePet() {
        Response response = PetApiClient.deletePet(petId);
        
        Asserter.assertStatusCode(response, 200);
        saveStepLog("Pet deleted successfully");
    }

    @Step("{0}")
    private void saveStepLog(String message) {
        // This method is used to log steps in Allure report
    }
}
