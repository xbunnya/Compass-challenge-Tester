package sicred.services;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class ConfigTest {
    
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v1";
    }
}
