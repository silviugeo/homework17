package com.endava.petclinic.client;

import com.endava.petclinic.filters.AuthenticationFilter;
import com.endava.petclinic.filters.LogFilter;
import com.endava.petclinic.model.PetType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.util.EnvReader.*;
import static io.restassured.RestAssured.given;

public class PetTypeClient {

    public Response createPetType(PetType petType) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .contentType(ContentType.JSON)
                .body(petType)
                .post("/api/pettypes");
    }

    public Response getPetTypeById(Long petTypeId) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("petTypeId", petTypeId)
                .get("/api/pettypes/{petTypeId}");
    }

    public Response getPetTypeList() {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .get("/api/pettypes");
    }

    public Response deletePetTypeById(Long petTypeId) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("petTypeId", petTypeId)
                .delete("/api/pettypes/{petTypeId}");
    }

    public Response updatePetById(Long petTypeId, PetType petType) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("petId", petTypeId)
                .body(petType)
                .contentType(ContentType.JSON)
                .put("/api/pettypes/{petId}");
    }
}
