package sicred.test.restricoes;

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
import static sicred.services.Endpoints.RESTRICOES;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@Epic("Testes de /restricoes método GET")
public class GETrestricoesTest extends BaseRest {

    @Test
    public void consultaRestricao() {
        String cpf_com_restricao = "97093236014";
        Response response = getR(RESTRICOES, cpf_com_restricao);
        response.then().assertThat().statusCode(200);
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/restricoes/get_200.json"));
    }

    @Test
    public void consultaRestricaoInexistente() {
        String cpf_sem_restricao = "999999999";
        Response response = getR(RESTRICOES, cpf_sem_restricao);
        response.then().assertThat().statusCode(204);
    }

}
