Feature: As a user, I should be able to log in.

  @negative_01
  Scenario Outline: Verify login with invalid credentials
    Given user is on the login page
    When the user enters organization url
    And user enters "<username>" and "<password>"
    And user clicks the login button
    Then verify an error message "You have not signed up for an ID or an incorrect password."


    Examples:
      | username                    | password      |
      | guestddddddd@mdmdmd.id      | Passw0rd!     |
      | invaliduser@wrongdomain.com | QAtest2025@#$ |
      | testuser@notvalidnet.io     | Secure#88     |
      | user@doubleat.com           | MyLogin@123   |
