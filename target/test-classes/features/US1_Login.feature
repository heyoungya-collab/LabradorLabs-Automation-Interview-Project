@US1
Feature: User login

  @login_positive
  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters organization url
    And user enters a valid email and a valid password
    And user clicks the login button
    Then user should see the dashboard

