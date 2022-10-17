@smoke
Feature:NextBaseCrm app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different account.

  Accounts are:
  helpdesk1@cybertekschool.com
  helpdesk2@cybertekschool.com
  helpdesk3@cybertekschool.com
  marketing1@cybertekschool.com
  marketing2@cybertekschool.com
  marketing3@cybertekschool.com
  hr1@cybertekschool.com
  hr2@cybertekschool.com
  hr3@cybertekschool.com


  @login
  Scenario Outline: : Login for different employees
    Given user is on the login page
    When user enters "<username>","<password>"
    And user clicks to login button
    Then user should see username on the profile tab
    Examples: employees credentials
      | username                      | password |
      | helpdesk1@cybertekschool.com  | UserUser |
      | helpdesk2@cybertekschool.com  | UserUser |
      | helpdesk3@cybertekschool.com  | UserUser |
      | marketing1@cybertekschool.com | UserUser |
      | marketing2@cybertekschool.com | UserUser |
      | marketing3@cybertekschool.com | UserUser |
      | hr1@cybertekschool.com        | UserUser |
      | hr2@cybertekschool.com        | UserUser |
      | hr3@cybertekschool.com        | UserUser |

















