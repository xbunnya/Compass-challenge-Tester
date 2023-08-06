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
import org.modelmapper.ModelMapper;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@Epic("Testes de /simulacoes método POST")
public class POSTsimulacoesTest extends BaseRest {
    VariaveisFaker variaveisFaker = new VariaveisFaker();
    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void criaSimulacao() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);

        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(201);
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_201.json"));
    }
}
