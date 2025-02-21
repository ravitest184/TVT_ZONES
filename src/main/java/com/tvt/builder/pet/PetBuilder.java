package com.tvt.builder.pet;

import com.github.javafaker.Faker;
import com.tvt.dto.Pet.CreatePet;
import com.tvt.dto.Pet.Category;
import com.tvt.dto.Pet.Tag;
import java.util.Arrays;
import java.util.ArrayList;

public class PetBuilder {
    private static final Faker faker = new Faker();

    public static CreatePet createPetBuilder() {
        CreatePet pet = new CreatePet();
        pet.setId(faker.number().numberBetween(1, 10000));
        pet.setName(faker.animal().name());
        pet.setStatus("available");
        pet.setPhotoUrls(Arrays.asList("http://example.com/photo1.jpg"));
        
        // Set category
        Category category = new Category();
        category.setId(faker.number().numberBetween(1, 100));
        category.setName(faker.animal().name());
        pet.setCategory(category);
        
        // Set tags
        Tag tag = new Tag();
        tag.setId(faker.number().numberBetween(1, 100));
        tag.setName(faker.lorem().word());
        pet.setTags(Arrays.asList(tag));
        
        return pet;
    }

    public static CreatePet createPetBuilder(int id, String status) {
        CreatePet pet = createPetBuilder();
        pet.setId(id);
        return pet;
    }
    public static CreatePet updatePetBuilder(String status) {
        CreatePet pet = createPetBuilder();
        pet.setStatus(status);
        return pet;
    }
}
