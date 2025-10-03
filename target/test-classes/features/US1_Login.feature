@US1
  Feature: As a user, I should be able to log in.

  Scenario: Verify login with credentials
    Given user is on the login page
    When user enters valid env
    And user enters valid username and valid password
    And user clicks the login button
    Then verify the dashboard is displayed


