package com.endava.petclinic.owner;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class GetOwnerListTest extends TestBaseClass {

    @Test
    public void shouldGetOwnerListTest() {
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        Response createOwnerResponse = ownerClient.createOwner(owner);
        createOwnerResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long ownerId = createOwnerResponse.body().jsonPath().getLong("id");

        //WHEN
        Response response = ownerClient.getOwnerList();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s}.firstName", withArgs(ownerId), is(owner.getFirstName()));// Varianta 1

        Owner actualOwner = response.body().jsonPath()
                .param("id", ownerId).getObject("find{ it -> it.id == id}", Owner.class);// Varianta 2
        assertThat(actualOwner, is(owner));

        List<Owner> ownerList = response.body().jsonPath().getList("", Owner.class);// Varianta 3
        assertThat(ownerList, hasItem(owner));
    }
}
