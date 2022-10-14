@chuck
Feature:User should be able to login using correct credentials

     @wip
    Scenario: Login as help desk
     When user enters helpdesk username
     And user enters helpdesk password
     Then user should navigate to home page

     @regression
    Scenario: Send message as help desk
      Given user is on the main page
      When user clicks the send message input box
       And user writes the message
       Then user clicks the send button

     @smoke
    Scenario: Comment for first sent message
      Given user is on the main page
       When user clicks first message's comment input box
       And user writes the comment
       Then user clicks the send comment button












