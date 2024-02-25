Feature: Get all users
  Background:
    Given The user is on the BaseURI
    And The authentication is completed to reach jira APIs

  Scenario: Test get all users method functionality
    When The user sends GET request to the get all users endpoint
    Then The status code should be 200
    And The response must contain array of users
