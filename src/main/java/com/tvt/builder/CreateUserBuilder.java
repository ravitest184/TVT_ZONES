package com.tvt.builder;

import com.github.javafaker.Faker;
import com.tvt.dto.CreateUser;

public class CreateUserBuilder {

    public static CreateUser createUserBuilder(String name){
        Faker faker = new Faker();
        
        CreateUser user = new CreateUser();
        user.setId(faker.number().randomDigit());
        user.setUsername(name);
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().phoneNumber());
        user.setUserStatus(faker.number().numberBetween(0, 1));
        
        return user;
    }
}
