
Feature:User should be able to login using correct credentials


    Scenario: Login as help desk
     When user enters helpdesk username
     And user enters helpdesk password
     Then user should navigate to home page

     @wip
    Scenario: Send message as help desk
      When user are on the homepage
      Then user writes the message and send

    @smoke
    Scenario: Comment for first message as help desk
      When user are on the homepage
      Then user comment to first sent message












