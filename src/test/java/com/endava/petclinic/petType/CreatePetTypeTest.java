package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreatePetTypeTest extends TestBaseClass {

    @Test
    public void shouldCreatePetType() {//positive test without "Given"
        //GIVEN
        PetType petType = testDataProvider.getPetType();

        //WHEN
        Response responsePetType = petTypeClient.createPetType(petType);

        //THEN
        responsePetType.then().statusCode(HttpStatus.SC_CREATED)
                .body("id", is(notNullValue()));

    }
}