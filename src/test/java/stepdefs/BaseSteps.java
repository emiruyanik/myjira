package stepdefs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

public abstract class BaseSteps {
    protected static Response response;
    protected static RequestSpecification request;
    protected final String GET_ALL_USERS_ENDPOINT;
    protected final String GET_USER_ENDPOINT;
    protected final String GET_FIND_USERS_ENDPOINT;
    protected final String POST_ISSUE_ENDPOINT;

    public BaseSteps() {
        RestAssured.baseURI = ConfigManager.getProperty("api.jira.URI");
        GET_ALL_USERS_ENDPOINT = ConfigManager.getProperty("api.get.all.users.endpoint");
        GET_USER_ENDPOINT=ConfigManager.getProperty("api.get.user.endpoint");
        GET_FIND_USERS_ENDPOINT =ConfigManager.getProperty("api.get.find.users.endpoint");
        POST_ISSUE_ENDPOINT =ConfigManager.getProperty("api.post.issue.endpoint");
    }
}
