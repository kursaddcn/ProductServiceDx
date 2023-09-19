package ProductControlTests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

// Product Update by Name, Code, Description, Brand, Currency and Price
public class ProductUpdateTests {
    @Test
    public void testUpdateName() {
        given().auth().basic("testUser", "password")
                .pathParams("name","name-new-test")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/name/{id}/{name}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

        given().auth().basic("testUser", "password")
                .pathParams("name","name-6")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/name/{id}/{name}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

    }

    @Test
    public void testUpdateCode() {
        given().auth().basic("testUser", "password")
                .pathParams("code","code-new-test")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/code/{id}/{code}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

        given().auth().basic("testUser", "password")
                .pathParams("code","code-5")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/code/{id}/{code}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

    }
    @Test
    public void testUpdateDescription() {
        given().auth().basic("testUser", "password")
                .pathParams("description","description-new-test")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/description/{id}/{description}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

        given().auth().basic("testUser", "password")
                .pathParams("description","des-5")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/description/{id}/{description}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

    }

    @Test
    public void testUpdateBrand() {

        given().auth().basic("testUser", "password")
                .pathParams("brand","brand-new-test")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/brand/{id}/{brand}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

        given().auth().basic("testUser", "password")
                .pathParams("brand","brand-5")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/brand/{id}/{brand}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

    }

    @Test
    public void testUpdateCurrency() {

        given().auth().basic("testUser", "password")
                .pathParams("currency","currency-new-test")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/currency/{id}/{currency}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

        given().auth().basic("testUser", "password")
                .pathParams("currency","currency-5")
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/currency/{id}/{currency}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

    }

    @Test
    public void testUpdatePrice() {

        given().auth().basic("testUser", "password")
                .pathParams("price",10)
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/price/{id}/{price}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

        given().auth().basic("testUser", "password")
                .pathParams("price",6)
                .pathParams("id","6508c9307c850d6099b828f0")
                .when().put("http://localhost:8080/updateProduct/price/{id}/{price}")
                .then()
                .statusCode(204)
                .body(is(notNullValue()));

    }



}
