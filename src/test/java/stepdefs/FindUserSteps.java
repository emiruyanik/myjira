package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import pojo.response.user.get_all_users.Users;
import utils.APIUtils;

import java.util.List;

public class FindUserSteps extends BaseSteps{
    List<Users> user;
    @When("The user sends GET request to the get find user endpoint with {string} query param")
    public void theUserSendsGETRequestToTheGetFindUserEndpointWithQueryParam(String name) {
        response= APIUtils.sendGetRequest(request,GET_FIND_USERS_ENDPOINT,"query",name);
        user=response.as(new TypeRef<List<Users>>() {
        });


    }

    @And("The dsiplay name should contain {string}")
    public void theDsiplayNameShouldContain(String name) {
        System.out.println(user.get(0).getDisplayName().toLowerCase().contains(name));
        Assertions.assertThat(user.get(0).getDisplayName().toLowerCase().contains(name)).isTrue();
    }
}
