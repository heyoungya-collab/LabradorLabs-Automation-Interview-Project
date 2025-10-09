Feature: As a user, I should be able to log in.


  @empty_email
  Scenario: Verify error message when email field is empty
    Given user is on the login page
    When user enters organization url
    And user enters a valid password
    And user clicks the login button
    Then verify an email empty Error Message "Please enter your ID." is displayed

  @empty_password
  Scenario: Verify error message when password field is empty
    Given user is on the login page
    When user enters organization url
    And user enters a valid email
    And user clicks the login button
    Then verify a password empty Error Message "Please enter your password." is displayed