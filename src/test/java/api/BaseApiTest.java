package api;

import endpoint.RequestSpecHandler;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    public void beforeAll(){
        RequestSpecHandler requestSpecHandler = new RequestSpecHandler();
        requestSpecHandler.initRequestSpecification();
    }
}
