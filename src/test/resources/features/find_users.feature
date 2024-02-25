Feature: Find Users

  Background:
    Given The user is on the BaseURI
    And The authentication is completed to reach jira APIs

  Scenario:Test find user method functionality
    When The user sends GET request to the get find user endpoint with "emir" query param
    Then The status code should be 200
    And The dsiplay name should contain "emir"