package ProductControlTests;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

// Product Search Tests for positive and negative paths.
@QuarkusTest
public class ProductSearchTests {
    @Test
    public void testExistingProductSearchByName() {
        given().auth().basic("testUser", "password")
                .pathParams("ProductName","name-1000")
                .when().get("http://localhost:8080/searchProduct/name/{ProductName}")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }
    @Test
    public void testNotExistingProductSearchByName() {

        given().auth().basic("testUser", "password")
                .pathParams("ProductName","nothing")
                .when().get("http://localhost:8080/searchProduct/name/{ProductName}")
                .then()
                .statusCode(200)
                .body(is("No element found with given criteria."));
    }

    @Test
    public void testExistingProductSearchByCode() {

        given().auth().basic("testUser", "password")
                .pathParams("ProductCode","code-1000")
                .when().get("http://localhost:8080/searchProduct/code/{ProductCode}")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }
    @Test
    public void testNotExistingProductSearchByCode() {

        given().auth().basic("testUser", "password")
                .pathParams("ProductCode","nothing")
                .when().get("http://localhost:8080/searchProduct/code/{ProductCode}")
                .then()
                .statusCode(200)
                .body(is("No element found with given criteria."));
    }
    @Test
    public void testExistingProductSearchByBrand() {

        given().auth().basic("testUser", "password")
                .pathParams("ProductBrand","brand-1000")
                .when().get("http://localhost:8080/searchProduct/brand/{ProductBrand}")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }
    @Test
    public void testNotExistingProductSearchByBrand() {

        given().auth().basic("testUser", "password")
                .pathParams("ProductBrand","nothing")
                .when().get("http://localhost:8080/searchProduct/brand/{ProductBrand}")
                .then()
                .statusCode(200)
                .body(is("No element found with given criteria."));
    }

    @Test
    public void testExistingProductSearchByID() {

        given().auth().basic("testUser", "password")
                .pathParams("ProductID","6508c94d7c850d6099b828f1")
                .when().get("http://localhost:8080/searchProduct/id/{ProductID}")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }

    @Test
    public void testNotExistingProductSearchByID() {
        given().auth().basic("testUser", "password")
                .pathParams("ProductID","6508c94d7c850d6099b80000")
                .when().get("http://localhost:8080/searchProduct/id/{ProductID}")
                .then()
                .statusCode(200)
                .body(is("No element found with given criteria."));
    }

    @Test
    public void testNotExistingProductSearchByPriceInterval() {
        given().auth().basic("testUser", "password")
                .pathParams("minPrice","-100")
                .pathParams("maxPrice","0")
                .when().get("http://localhost:8080/searchProduct/priceInterval/{minPrice}/{maxPrice}")
                .then()
                .statusCode(200)
                .body(is("No element found with given criteria."));
    }

    @Test
    public void testExistingProductSearchByPriceInterval() {
        given().auth().basic("testUser", "password")
                .pathParams("minPrice", Integer.MIN_VALUE)
                .pathParams("maxPrice", Integer.MAX_VALUE)
                .when().get("http://localhost:8080/searchProduct/priceInterval/{minPrice}/{maxPrice}")
                .then()
                .statusCode(200)
                .body(is(notNullValue()));
    }

}