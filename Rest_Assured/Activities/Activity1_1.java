package activities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1_1 {

    @Test
    public void exampleQueryParameter() {
        Response response =
                given().baseUri("https://petstore.swagger.io/v2/pet").
                        header("ContentType", "application/jason").
                        queryParam("status", "alive").
                        log().all().
                        when().get("/findByStatus");

        System.out.println(response.getHeaders());
        System.out.println(response.getBody().asString());

        String petStatus = response.then().extract().path("[0].status");
        Assert.assertEquals(petStatus, "alive");
    }

    @Test
    public void examplePathParameter() {
        given().baseUri("https://petstore.swagger.io/v2/pet").
                header("ContentType", "application/jason").
                pathParam("petId", 77232).
                log().all().
                when().get("/{petId}").
                then().statusCode(200).
                body("name", equalTo("Riley")).
                body("status", equalTo("alive")).
                log().all();
    }
}
