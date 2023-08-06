package sicred.services;

import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import lombok.Setter;

@Setter
public class ConfigTeste {

    public String baseURI;

    @BeforeAll
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
    }
}
