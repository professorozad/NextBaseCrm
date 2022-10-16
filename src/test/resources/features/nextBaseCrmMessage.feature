@regression
Feature: NextBaseCrm app message feature
  User Story
  As a user, I should be able to send messages by clicking on Message tab under Active Stream.



Scenario: Send message as help desk
Given user is on the main page
When user clicks the send message input box
And user writes the message
Then user clicks the send button


Scenario: Comment for first sent message
Given user is on the main page
When user clicks first message's comment input box
And user writes the comment
Then user clicks the send comment button