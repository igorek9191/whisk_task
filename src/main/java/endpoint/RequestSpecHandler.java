package endpoint;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

@Getter
public class RequestSpecHandler {

    protected static RequestSpecification spec;

    private final String uri = "https://api.whisk-dev.com/";
    private final String token = "Hp1wwzc0AMBi2YyXE2UPqB2pQQoAyG1GLgf9fbDbtCRXNBNONrfMTLGHNohqaqyx";

    public void initRequestSpecification() {
        spec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri(uri)
                .addHeader("Authorization", "Bearer " + token)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }
}