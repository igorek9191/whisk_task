package api;

import endpoint.ListEndpoint;
import io.qameta.allure.Feature;
import model.PostListRequest;
import model.getErrorResponse.GetErrorResponse;
import model.postResponse.PostListResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("API tests")
public class DeleteListTest extends BaseApiTest {

    private ListEndpoint listEndpoint = new ListEndpoint();
    private PostListResponse postListResponse;
    private String shoppingListId;
    private final String name = "Some_api_name_2";
    private final boolean primary = false;
    private final String expectedMessage = "Shopping list not found";

    @BeforeAll
    public void post() {
        postListResponse = listEndpoint.post(PostListRequest.builder()
                .name(name)
                .primary(primary)
                .build());
        shoppingListId = postListResponse.getList().getId();
    }

    @DisplayName("Check of 'delete' and 'get' methods in '/list/v2' endpoint")
    @Test
    public void deleteListTest() {
        listEndpoint.delete(shoppingListId);

        GetErrorResponse response = listEndpoint.get(shoppingListId, 400, GetErrorResponse.class);
        assertEquals(expectedMessage, response.getMessage(), "Check of message in 'get' response after 'delete'");
    }
}