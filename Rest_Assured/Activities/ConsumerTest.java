package pactproject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //Create the headers map
    Map<String, String> headers = new HashMap<>();

    //Create contract
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        //Set our headers to Json
        headers.put("Content-Type", "application/json");

        //Set the req/res body
        DslPart requestResponsebody = new PactDslJsonBody()
                .numberType("id", 100)
                .stringType("firstname", "Renu")
                .stringType("lastname", "Nair")
                .stringType("email", "renunair@in.ibm.com");

        //Create the contract
        return builder.given("POST Request")
                .uponReceiving("request to create a user")
                    .method("POST")
                    .path("/api/users")
                    .headers(headers)
                    .body(requestResponsebody)
                .willRespondWith()
                    .status(201)
                    .body(requestResponsebody)
                .toPact();

    }

    //Test
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void consumerTest(){
        //ReqBody
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 100);
        reqBody.put("firstname", "Renu");
        reqBody.put("lastname","Nair");
        reqBody.put("email", "renunair@in.ibm.com");

        //Send POST Request
        given().baseUri("http://localhost:8282/api/users")
                .headers(headers)
                .body(reqBody)
                .log().all()
                .when().post()
                .then().statusCode(201)
                .body("email", equalTo("renunair@in.ibm.com")).log().all();

    }



}
