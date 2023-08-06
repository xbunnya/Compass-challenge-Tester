package sicred.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;

public class BaseRest {
    public RequestSpecification requestSpec;

    public BaseRest() {
        setUp();
    }

    public Response getR(String endpoint, String cpf) {
        return given()
                .spec(requestSpec)
                .get(endpoint + "/" + cpf)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getS(String endpoint) {
        return given()
                .spec(requestSpec)
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response post(Object payload, String endpoint) {
        return given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    private void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
