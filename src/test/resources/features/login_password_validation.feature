Feature: As a user, I should be able to log in.


  @invalid_password_format
  Scenario Outline: Verify invalid password formats are rejected with error message
    Given user is on the login page
    When user enters organization url
    And user enters invalid "<password>"
    Then verify an error message "Please enter 8~20 characters in combination of English letters, numbers, and special symbols." is displayed

    Examples:
      | password              |
      | short1                |
      | onlyletters           |
      | 123456789012345678901 |
      |                       |
      | noSpecial123          |
      | NoNumber!             |
      | NOSMALL123!           |
      | nosmall123!           |
      | white space123!       |
      | validPASS123!         |