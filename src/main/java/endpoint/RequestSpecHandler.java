package endpoint;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import property_handling.GeneralProperties;

@Getter
public class RequestSpecHandler {

    protected static RequestSpecification spec;

    protected GeneralProperties generalProperties = ConfigFactory.create(GeneralProperties.class);

    public void initRequestSpecification() {
        spec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri(generalProperties.uri())
                .addHeader("Authorization", "Bearer " + generalProperties.token())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();
    }
}