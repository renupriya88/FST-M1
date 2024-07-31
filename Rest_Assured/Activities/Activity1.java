package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity1 {
    String baseURL = "https://petstore.swagger.io/v2/pet";

    @Test
    @Order(1)
    public void postrequest(){
        String body =
                "{"+
                        " \"id\" : 77232,"+
                        " \"name\": \"Riley\","+
                        " \"status\" : \"alive\""+
"}";

        Response response = given().contentType(ContentType.JSON)
                .body(body)
                .when().post(baseURL);

        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test
    @Order(2)
    public void getrequest(){
        Response response = given().contentType(ContentType.JSON)
                .when()
                .pathParam("id", "77232")
                .get(baseURL+"/{id}");

        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test
    @Order(3)
    public void deleterequest(){
        Response response = given().contentType(ContentType.JSON)
                .when()
                .pathParam("id", "77232")
                .delete(baseURL+"/{id}");

        response.then().body("message", equalTo("77232"));
        response.then().statusCode(200);
    }

}
