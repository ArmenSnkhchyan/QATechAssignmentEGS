package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requests.JsonPlaceholder;

import static helpers.Constants.JSON_PLACEHOLDER_BASE_URL;
import static helpers.Constants.REQUEST_BODY;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class JsonPlaceholderAPITest {

    JsonPlaceholder jsonPlaceholder;
    Response response;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = JSON_PLACEHOLDER_BASE_URL;
        jsonPlaceholder = new JsonPlaceholder();
    }

    @Test
    public void checkGetRequest() {
        response = jsonPlaceholder.getRequest();

        assertEquals(200, response.statusCode());
        assertNotEquals("id", response.jsonPath().getString("title[1]"));
    }

    @Test
    public void checkGetRequestById() {
        response = jsonPlaceholder.getRequestById("3");

        assertEquals(200, response.statusCode());
        assertEquals("Nathan@solon.io", response.jsonPath().getString("email[3]"));
        assertNotEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }

    @Test
    public void checkPostRequest() {
        response = jsonPlaceholder.postRequest(REQUEST_BODY);

        assertEquals(201, response.statusCode());
        assertEquals("newTitle", response.jsonPath().getString("title"));
        assertEquals("newBody", response.jsonPath().getString("body"));
        assertEquals("15", response.jsonPath().getString("userId"));
    }
}