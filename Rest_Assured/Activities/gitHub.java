import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class gitHub {
    RequestSpecification request ;
    String sshKey;
    int id;

    @BeforeClass
    public void setup(){
        request = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com")
                .build();
        }

    @Test(priority = 1)
    public void post(){
        String reqBody = "{"+"\"title\": \"TestAPIKey\","+"\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICy6ZLLZ7dC5zPofgO6rsCc+nCrbw0bKlq2hxHcnhV14 azuread\\renupriyanair@IBM-PF2P2DB1\"}";

        Response response = given().spec(request)
                .body(reqBody)
                .auth().oauth2("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")
                .when().post("/user/keys");

        response.body().prettyPrint();

        response.then().statusCode(201);
        id = response.then().extract().path("id");
        System.out.println(id);
        Reporter.log("Post Completed");



    }

    @Test(priority = 2)
    public void get(){
        Response response = given().spec(request)
                .when()
                .log().all()
                .auth().oauth2("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")
                .pathParam("id", id)
                .get("/user/keys/{id}");


        response.then().statusCode(200);
        Reporter.log("Get Completed");
    }

    @Test(priority = 3)
    public void delete(){
        Response response = given().spec(request)
                .when()
                .log().all()
                .auth().oauth2("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")
                .pathParam("id", id)
                .delete("/user/keys/{id}");


        response.then().statusCode(204);
        Reporter.log("Delete Completed");

    }


}
