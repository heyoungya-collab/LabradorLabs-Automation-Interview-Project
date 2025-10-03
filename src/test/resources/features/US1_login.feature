@US1
Feature: User login

  @positive
  Scenario: Successful login with valid credentials
    Given user is on the login page
    When the user enters organization url
    And user enters a valid username and a valid password
    And user clicks the login button
    Then user should see the dashboard

