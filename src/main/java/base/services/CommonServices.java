package base.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static base.CommonConstants.BASE_URI;


public class CommonServices {
    protected RequestSpecification request = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    protected ResponseSpecification responseSuccess = new ResponseSpecBuilder()
            .expectStatusCode(HttpStatus.SC_OK)
            .build();

}
