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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@Epic("Testes de /simulacoes método POST")
public class POSTsimulacoesTest extends BaseRest {
    VariaveisFaker variaveisFaker = new VariaveisFaker();
    ModelMapper modelMapper = new ModelMapper();
    private String simulacaoID;
    private String cpf;

    @Test
    public void criaSimulacao() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);

        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(201);
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_201.json"));
        simulacaoID = response.jsonPath().getString("_id");
        cpf = response.jsonPath().getString("cpf");
        System.out.println(cpf);
        System.out.println(simulacaoID);
    }

    @Tag("Campo vazio")
    @Test
    public void criaSimulacaoNomeNulo() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);
        simulacao.setNome(null);

        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(400)
                .body("erros.nome", equalTo("Nome não pode ser vazio"));
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_nome_400.json"));
    }

    @Tag("Campo vazio")
    @Test
    public void criaSimulacaoSemNome() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);
        simulacao.setNome(" ");

        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(400)
                .body("erros.nome", equalTo("Nome não pode ser vazio"));
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_nome_400.json"));
    }

    @Tag("Campo nulo")
    @Test
    public void criaSimulacaoCPFNulo() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);
        simulacao.setCpf(null);

        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(400)
                .body("erros.cpf", equalTo("CPF não pode ser vazio"));
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_cpf_400.json"));
    }

    @Tag("Campo vazio")
    @Test
    public void criaSimulacaoSemCPF() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);
        simulacao.setCpf(" ");

        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(400)
                .body("erros.cpf", equalTo("CPF não pode ser vazio"));
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_cpf_400.json"));
    }

    @Tag("Campo nulo")
    @Test
    public void CriaSimulacaoEmailNulo() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);
        simulacao.setEmail(null);
        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(400)
                .body("erros.email", equalTo("E-mail não deve ser vazio"));
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_email_400.json"));
    }

    @Tag("Campo vazio")
    @Test
    public void CriaSimulacaoEmailVazio() {
        SimulacaoPayload simulacao = modelMapper.map(variaveisFaker, SimulacaoPayload.class);
        simulacao.setEmail(" ");
        Response response = post(simulacao, SIMULACOES);
        response.then().assertThat().statusCode(400)
                .body("erros.email", equalTo("E-mail deve ser um e-mail válido"));
        assertThat(response.asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("sicred/resources/schemas/simulacoes/POST/post_email_400.json"));
    }
}
