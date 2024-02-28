package api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfProperties;

import static org.testng.Assert.assertNotEquals;


public abstract class BaseApiController {
    private static final String BASE_API_URL = ConfProperties.getProperty("api_url");
    private static final String TOKEN = ConfProperties.getProperty("token");

    protected RequestSpecification baseRequestSpecification() {
        return RestAssured.given()
                .baseUri(BASE_API_URL)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth()
                .preemptive()
                .oauth2(TOKEN);
    }

    protected JsonPath assertResponse(Response result) {
        assertNotEquals(401, result.statusCode(),
                "API authentication token has expired, please update in src/test/resources/auth.properties");
        return result.jsonPath();
    }
}
