package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import pojo.response.user.get_all_users.Users;
import utils.APIUtils;
import utils.TestDataWriter;

import java.util.List;

public class GetAllUsersSteps extends BaseSteps{
    List<Users>users;
    @Given("The user is on the BaseURI")
    public void theUserIsOnTheBaseURI() {
     request= RestAssured.given();
    }

    @And("The authentication is completed to reach jira APIs")
    public void theAuthenticationIsCompletedToReachJiraAPIs() {
        String username = System.getenv("jiraUsername");
        String token = System.getenv("jiraToken");
        request=request.auth().preemptive().basic(username,token);
    }

    @When("The user sends GET request to the get all users endpoint")
    public void theUserSendsGETRequestToTheGetAllUsersEndpoint() {
        response= APIUtils.sendGetRequest(request,GET_ALL_USERS_ENDPOINT);
        users=response.as(new TypeRef<List<Users>>() {
        });
        TestDataWriter.dataWriter("user.json",users.get(6));
    }

    @Then("The status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

    @And("The response must contain array of users")
    public void theResponseMustContainArrayOfUsers() {
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }
}
