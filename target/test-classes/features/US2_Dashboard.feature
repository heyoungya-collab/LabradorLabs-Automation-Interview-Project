@US2
Feature: AS a sure, I should be see all the main modules of the app.


  Scenario: Verify users see all the main modules of the app.
    Given user is on the login page
    When user enters valid env
    And user enters valid username and valid password
    And user clicks the login button
    Then Verify the user see the following modules:
      | Home       |
      | Projects   |
      | SCM        |
      | Statistics |
      | Policy     |
      | Settings   |

