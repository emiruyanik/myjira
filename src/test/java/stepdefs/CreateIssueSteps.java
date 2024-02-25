package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pojo.request.issue.Issue;
import utils.APIUtils;
import utils.TestDataReader;

public class CreateIssueSteps extends BaseSteps {
    @When("The user sends POST request to the create issue endpoint")
    public void theUserSendsPOSTRequestToTheCreateIssueEndpoint() {
        Issue issue = TestDataReader.dataReader("create-issue.json", Issue.class);
        response = APIUtils.sendPostRequest(request, POST_ISSUE_ENDPOINT, issue);
    }

    @And("The edit id should not be empty or null")
    public void theEditIdShouldNotBeEmptyOrNull() {
        System.out.println(response.jsonPath().getString("id"));
        Assertions.assertThat(response.jsonPath().getString("id")).isNotEmpty();
        Assertions.assertThat(response.jsonPath().getString("id")).isNotNull();
    }

    @And("The key should starts with {string}")
    public void theKeyShouldStartsWith(String key) {
        Assertions.assertThat(response.jsonPath().getString("key").startsWith(key)).isTrue();
    }
}
