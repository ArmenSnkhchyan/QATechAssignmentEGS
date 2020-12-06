package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JsonPlaceholder {

    public Response getRequest() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then().log().all()
                .extract().response();
    }

    public Response getRequestById(String id) {
        return given()
                .contentType(ContentType.JSON)
                .param("postId", id)
                .when()
                .get("/comments")
                .then().log().all()
                .extract().response();
    }

    public Response postRequest(String requestBody) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then().log().all()
                .extract().response();
    }
}