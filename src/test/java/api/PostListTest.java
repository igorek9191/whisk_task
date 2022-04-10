package api;

import endpoint.ListEndpoint;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import model.PostListRequest;
import model.postResponse.PostListResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("API tests")
public class PostListTest extends BaseApiTest {

    private ListEndpoint listEndpoint = new ListEndpoint();
    private SoftAssertions softAssertions = new SoftAssertions();
    private PostListResponse postListResponse;
    private String shoppingListId;
    private PostListResponse postListResponse1;
    private final String name = "Soma_api_name";
    private final boolean primary = false;

    @DisplayName("Check of 'post' and 'get' methods for 'list' endpoint")
    @Test
    public void testPost() {
        postListResponse = listEndpoint.post(PostListRequest.builder()
                .name(name)
                .primary(primary)
                .build());
        shoppingListId = postListResponse.getList().getId();

        postListResponse1 = listEndpoint.get(shoppingListId);

        softAssertions.assertThat(postListResponse1.getList().getId())
                .as("Check of list id from 'get' response")
                .isEqualTo(shoppingListId);
        softAssertions.assertThat(postListResponse1.getContent().getDetails().isEmpty())
                .as("Check that content from 'get' response is empty")
                .isEqualTo(true);
        softAssertions.assertAll();
    }

    @AfterAll
    @Step("Delete created list")
    public void deleteList(){
        listEndpoint.delete(shoppingListId);
    }
}