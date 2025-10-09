Feature: As a user, I should be able to log in.


  @invalid_username_format
  Scenario Outline: Verify invalid username formats are rejected with error message
    Given user is on the login page
    When user enters organization url
    And user enters invalid "<emails>"
    Then verify an login Email Error Message "Not the correct email format." is displayed

    Examples:
      | emails               |
      | user@@doubleat.com   |
      | user@domain..com     |
      | user name@domaincom  |
      | .user@domain.com     |
      | user.@domain.com     |


