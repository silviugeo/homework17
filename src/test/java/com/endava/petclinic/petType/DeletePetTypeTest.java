package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTypeTest extends TestBaseClass {

    @Test
    public void shouldDeletePetType() {
        //GIVEN
        PetType petType = fixture.createPetType()
                .getPetType();

        Long petTypeId = petType.getId();

        //WHEN
        Response response = petTypeClient.deletePetTypeById(petTypeId);

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}

