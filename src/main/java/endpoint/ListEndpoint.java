package endpoint;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.PostListRequest;
import model.postResponse.PostListResponse;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListEndpoint extends RequestSpecHandler {

    @Step("Making 'post' request for 'list' endpoint")
    public PostListResponse post(PostListRequest productRequest) {
        Response response = given()
                .spec(spec)
                .when()
                .body(productRequest)
                .post("/list/v2")
                .thenReturn();
        assertEquals(200, response.getStatusCode(), "Check of status code in response of 'post' method");
        return response.as(PostListResponse.class);
    }

    @Step("Making 'get' request for 'list' endpoint")
    public PostListResponse get(String listId) {
        Response response = given()
                .spec(spec)
                .when()
                .get("/list/v2/{id}", listId)
                .thenReturn();
        assertEquals(200, response.getStatusCode(), "Check of status code in response of 'get' method");
        return response.as(PostListResponse.class);
    }

    @Step("Making 'get' request for 'list' endpoint")
    public <T> T get(String listId, int statusCode, Class<T> tClass) {
        Response response = given()
                .spec(spec)
                .when()
                .get("/list/v2/{id}", listId)
                .thenReturn();
        assertEquals(statusCode, response.getStatusCode(), "Check of status code in response of 'get' method");
        return response.as(tClass);
    }

    @Step("Making 'delete' request for 'list' endpoint")
    public void delete(String listId) {
        Response response = given()
                .spec(spec)
                .when()
                .delete("/list/v2/{id}", listId)
                .thenReturn();
        assertEquals(200, response.getStatusCode(), "Check of status code in response of 'delete' method");
    }
}