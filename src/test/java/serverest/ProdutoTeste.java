package serverest;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class ProdutoTeste {
    static String token;
    static String campo_vazio = "  " + System.currentTimeMillis();
    static String produtoId;
    static Faker faker = new Faker();
    static String nome = faker.commerce().productName();
    static int preco = (int) faker.number().randomNumber();
    static String descricao = faker.lorem().sentence();
    static int quantidade = (int) faker.number().randomNumber();
    LoginTeste loginTeste;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
    }

    @BeforeEach
    public void Login() {

        LoginTeste loginTeste = new LoginTeste();
        token = loginTeste.logaUsuario();
    }

    @Test
    public void cadastraProduto() {

        Produto produto = new Produto(nome, preco, descricao, quantidade);

   produtoId =
		 given()		  
            .contentType(ContentType.JSON)
            .headers("authorization", token)
            .body(produto)
            .log().all()
          .when()
            .post("/produtos")
          .then()
            .log().all()
            .statusCode(201)            
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .body("_id", isA(String.class))
            .extract()
            .path("_id");

   
        return;


    }
    


    public String getProdutoid() {

        return produtoId;
    }
    public void setProdutoId(String produtoId) {
        ProdutoTeste.produtoId = produtoId;
    }

    @Test
    public void editaProdutoPorId() {
        Produto produto = new Produto(nome, preco, descricao, quantidade);

        given()
            .contentType(ContentType.JSON)
            .headers("authorization", token)
            .body(produto)
          .when()
            .put("/produtos/" + produtoId)
          .then()
            .log().all()
            .body("message", equalTo("Registro alterado com sucesso"))
            .statusCode(200);

    }



    @Test
    public void naoCadastraProdutoSemNome() {

        Produto produto = new Produto(campo_vazio, preco, descricao, quantidade);

        given()
            .contentType(ContentType.JSON)
            .headers("authorization", token)
            .body(produto)
            .log().all()
          .when()
            .post("/produtos")
          .then()
            .log().all()
            .body("message", equalTo("Campo nome não pode ficar em branco"))
            .statusCode(400);

    }

    @Test
    public void naoExcluiProdutoEmCarrinho() {


        given()
            .contentType(ContentType.JSON)
            .headers("authorization", token)
          .when()
            .delete("/produtos/BeeJh5lz3k6kSIzA")
          .then()
            .statusCode(400);


    }


    @Test
    public void naoCadastraProdutoJaExistente() {
        String nome = "Samsung 60 polegadas";
        Produto produto = new Produto(nome, preco, descricao, quantidade);

        given()
            .contentType(ContentType.JSON)
            .headers("authorization", token)
            .body(produto)
            .log().all()
          .when()
            .post("/produtos")
          .then()
            .log().all()
            .statusCode(400);


    }

    @Test
    public void ListaProdutos() {

        given()
            .contentType(ContentType.JSON)
          .when()
            .get("/produtos")
          .then()
            .statusCode(200);

    }
    @Test
    public void naoCadastraProdutoSemAutenticar() {

        Produto produto = new Produto(nome, preco, descricao, quantidade);

        given()
            .contentType(ContentType.JSON)
            .body(produto)
            .log().all()
          .when()
            .post("/produtos")
          .then()
            .log().all()
            .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
            .statusCode(401);

    }

    @Test public void excluiProdutoPorId() {

        given()
            .contentType(ContentType.JSON)
            .headers("authorization", token)
          .when()
            .delete("/produtos/" + produtoId)
          .then()
            .statusCode(200);

    }

}