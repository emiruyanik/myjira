package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pojo.response.user.get_all_users.Users;
import pojo.response.user.get_user.SpecificUser;
import utils.APIUtils;
import utils.TestDataReader;

public class GetUserSteps extends BaseSteps {

    Users user;
    SpecificUser specificUser;

    @When("The user sends GET request to the get user endpoint")
    public void theUserSendsGETRequestToTheGetUserEndpoint() {
        user = TestDataReader.dataReader("user.json", Users.class);
        System.out.println(user.getAccountId());
        response = APIUtils.sendGetRequest(request, GET_USER_ENDPOINT, "accountId", user.getAccountId());
        specificUser=response.as(SpecificUser.class);

    }

    @And("The response should contain true informations about specific id")
    public void theResponseShouldContainTrueInformationsAboutSpecificId() {
        SoftAssertions softAssertions=new SoftAssertions();
        softAssertions.assertThat(user.getAccountId()).isEqualTo(specificUser.getAccountId());
        softAssertions.assertThat(user.getAccountType()).isEqualTo(specificUser.getAccountType());
        softAssertions.assertThat(user.getDisplayName()).isEqualTo(specificUser.getDisplayName());
        softAssertions.assertAll();
    }
}
