Feature: Create Issue

  Background:
    Given The user is on the BaseURI
    And The authentication is completed to reach jira APIs

    Scenario: Test create issue method functionality
      When The user sends POST request to the create issue endpoint
      Then The status code should be 201
      And The edit id should not be empty or null
      And The key should starts with "T23E"