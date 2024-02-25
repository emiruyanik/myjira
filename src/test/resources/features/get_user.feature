Feature: Get user
  Background:
    Given The user is on the BaseURI
    And The authentication is completed to reach jira APIs

    Scenario:Get user method functionality with user id
      When The user sends GET request to the get user endpoint
      Then The status code should be 200
      And The response should contain true informations about specific id