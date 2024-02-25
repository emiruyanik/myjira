package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class APIUtils {
    public static Response sendGetRequest(RequestSpecification request, String endpoint) {
        return request
                .accept(ContentType.JSON)
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, String key, String value) {
        return request
                .accept(ContentType.JSON)
                .queryParam(key, value)
                .when()
                .get(endpoint);
    }

    public static Response sendPostRequest(RequestSpecification request, String endPoint, Object object) {
        return request.accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(object)
                .log().all()
                .when()
                .post(endPoint);
    }

    public static Response sendPostRequest(RequestSpecification request, String endpoint, String key, File file) {
        return request.header("X-Atlassian-Token", "no-check")
                .contentType(ContentType.MULTIPART)
                .multiPart(key,file)
                .log().all()
                .when()
                .post(endpoint);
    }
}
