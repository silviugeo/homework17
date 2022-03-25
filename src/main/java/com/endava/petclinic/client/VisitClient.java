package com.endava.petclinic.client;

import com.endava.petclinic.filters.AuthenticationFilter;
import com.endava.petclinic.filters.LogFilter;
import com.endava.petclinic.model.Visit;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.util.EnvReader.*;
import static io.restassured.RestAssured.given;

public class VisitClient {

    public Response createVisit(Visit visit) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .contentType(ContentType.JSON)
                .body(visit)
                .post("/api/visits");
    }

    public Response getVisitById(Long visitId) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("visitId", visitId)
                .get("/api/visits/{visitId}");
    }

    public Response getVisitList() {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .get("/api/visits");
    }

    public Response deleteVisitById(Long visitId) {

        return given().filters(new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("visitId", visitId)
                .delete("/api/visits/{visitId}");
    }
}
