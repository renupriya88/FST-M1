package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity2 {
    String baseURL = "https://petstore.swagger.io/v2/user";

    @Test
    @Order(1)
    public void postrequest(){
        File input = new File("src/test/java/activities/activity2.json");

        Response response = given().contentType(ContentType.JSON)
                .body(input)
                .when().post(baseURL);


        response.getBody().prettyPrint();

    }

    @Test
    @Order(2)
    public void getrequest(){
        File ouput = new File("src/test/java/activities/activity2_output.json");

        Response response = given().contentType(ContentType.JSON)
                .when()
                .pathParam("username","chinjumol")
                .get(baseURL+"/{username}");

        String responseBody = response.asPrettyString();

        try {
            ouput.createNewFile();
            FileWriter writer = new FileWriter(ouput.getPath());
            writer.write(responseBody);
            writer.close();
        } catch (IOException excp){
            excp.printStackTrace();
        }

        response.then().body("id", equalTo(5489));
        response.then().body("username", equalTo( "chinjumol"));
        response.then().body("firstName", equalTo( "Justin"));
        response.then().body("lastName", equalTo( "Case"));
        response.then().body("email", equalTo( "justincase@mail.com"));
        response.then().body("password", equalTo( "password123"));
        response.then().body("phone", equalTo( "9812763450"));



    }

    @Test
    @Order(3)
    public void deleterequest(){
        Response response = given().contentType(ContentType.JSON)
                .when()
                .pathParam("username", "chinjumol")
                .delete(baseURL+"/{username}");

        response.then().body("message", equalTo("chinjumol"));
        response.then().statusCode(200);
    }

}
