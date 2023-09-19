package ProductControlTests;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

// Product Insertion Test with Faker Lib
public class ProductInsertionTests {
    @Test
    public void testProductInsertion() {
        Faker faker = new Faker();
        String payload = "{\n" +
                "    \"name\": \" +"+ faker.name().firstName() +"+\",\n" +
                "    \"code\":\"+"+faker.name().username()+"+\",\n" +
                "    \"description\": \"+"+faker.address().fullAddress()+"+\",\n" +
                "    \"brand\": \"+"+faker.company().name()+"+\",\n" +
                "    \"currency\": \"+"+faker.currency().toString()+"+\",\n" +
                "    \"price\": 1000,\n" +
                "    \"stockCount\": 1000,\n" +
                "    \"isDeleted\":false\n" +
                "}";

        given().auth().basic("testUser", "password")
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post("http://localhost:8080/addProduct")
                .then()
                .statusCode(201)
                .body(is(notNullValue()));
    }
}
