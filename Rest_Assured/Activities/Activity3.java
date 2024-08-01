package activities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class Activity3 {
    RequestSpecification reqspec;
    ResponseSpecification respspec;


    @BeforeClass
    public void setup(){
        reqspec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();

        respspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
// Check response content type
                .expectContentType("application/json")
// Check size of the array in a JSON response
                .expectBody("status", equalTo("alive"))
// Build response specification
                .build();
    }

    @DataProvider
    public Object[][] inputdata(){
        Object[][] testData = new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
        return testData;
    }

    @Test(priority = 1)
    public void postrequest(){
        String body = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";

        Response response = given().spec(reqspec)
                .body(body)
                .when().post();

        response.body().prettyPrint();

        body = "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";

        response = given().spec(reqspec)
                .body(body)
                .when().post();

        response.body().prettyPrint();

        response.then().spec(respspec);
        response.then().body("status", equalTo("alive"));
    }

    @Test(dataProvider = "inputdata", priority = 2)
    public void getrequest(int id, String name, String status){
        Response response = given().spec(reqspec)
                .when()
                .pathParam("id", id)
                .get("/{id}");

        response.then().spec(respspec);
        response.then().body("status", equalTo("alive"));
    }

    @Test(dataProvider = "inputdata", priority = 3)
    public void deleterequest(int id, String name, String status){
        Response response = given().spec(reqspec)
                .when()
                .pathParam("id", id)
                .delete("/{id}");

        response.then().body("code", equalTo(200));
    }
}
