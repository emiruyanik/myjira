Feature: Add attachment

  Background:
    Given The user is on the BaseURI
    And The authentication is completed to reach jira APIs

Scenario: Test add attachment functionality
  When The user sends POST request to the add attachment endpoint with "T23E-2" key
  Then The status code should be 200
  And The attachment id should not be null or empty
  And File name should contain "team-1.txt"
  And Display name shouid be "[Emir Uyanık]"
