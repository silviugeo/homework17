package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class CreateVisitTest extends TestBaseClass {

    @Test
    public void shouldCreateVisit() {
        //GIVEN
        Owner owner = fixture.createOwner()
                .getOwner();

        PetType petType = fixture.createPetType()
                .getPetType();

        Pet pet = fixture.createPet(owner, petType)
                .getPet();

        Visit visit = testDataProvider.getVisit(pet);

        //WHEN
        Response responseVisit = visitClient.createVisit(visit);

        //THEN
        responseVisit.then().statusCode(HttpStatus.SC_CREATED);
    }
}
