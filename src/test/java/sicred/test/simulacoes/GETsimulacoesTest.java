package sicred.test.simulacoes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import sicred.services.VariaveisFaker;
import sicred.services.BaseRest;
import sicred.services.Endpoints;
import static sicred.services.Endpoints.SIMULACOES;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@Epic("Testes de /simulacoes método GET")
public class GETsimulacoesTest extends BaseRest {

    @Test
    public void listaSimulacoes() {
        Response response = getS(SIMULACOES);
        response.then().assertThat().statusCode(200);
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/GET/get_200.json"));

    }

}