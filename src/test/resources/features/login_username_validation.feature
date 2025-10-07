Feature: As a user, I should be able to log in.


  @invalid_username_format
  Scenario Outline: Verify invalid username formats are rejected with error message
    Given user is on the login page
    When user enters organization url
    And user enters invalid "<username>"
    Then verify an error message "Not the correct email format." is displayed

    Examples:
      | username             |
      | user@@doubleat.com   |
      | user_nodot@domain    |
      | user@domaincom       |
      | user@domain..com     |
      | user name@domain.com |
      | .user@domain.com     |
      | user.@domain.com     |
      |                      |