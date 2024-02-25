package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import utils.APIUtils;

import java.io.File;

public class AddAttachmentSteps extends BaseSteps{
    @When("The user sends POST request to the add attachment endpoint with {string} key")
    public void theUserSendsPOSTRequestToTheAddAttachmentEndpointWithKey(String key) {
        String endpoint =POST_ISSUE_ENDPOINT+"/"+key+"/"+"attachments";
        File file=new File(System.getProperty("user.dir")+"/src/test/resources/test_data/team-1.txt");
        response= APIUtils.sendPostRequest(request,endpoint,"file",file);
    }

    @And("The attachment id should not be null or empty")
    public void theAttachmentIdShouldNotBeNullOrEmpty() {
        Assertions.assertThat(response.jsonPath().getString("id")).isNotNull();
        Assertions.assertThat(response.jsonPath().getString("id")).isNotEmpty();
    }

    @And("File name should contain {string}")
    public void fileNameShouldBe(String fileName) {
        Assertions.assertThat(response.jsonPath().getString("filename").contains(fileName)).isTrue();
    }

    @And("Display name shouid be {string}")
    public void displayNameShoulddBe(String displayName) {
        Assertions.assertThat(response.jsonPath().getString("author.displayName")).isEqualTo(displayName);
    }


}
