
Feature: NextBaseCrm app message feature
  User Story
  As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  Background: for the scenarios in the feature file, user is expected to be on home page
    Given user navigates to nextBaseCrm home page with valid credentials

  @regression
  Scenario: Send message to all employees
    When user clicks the send message input box
    And user writes the message
    Then user clicks the send button

  @smoke
  Scenario: Comment for first sent message
    When user clicks first message's comment input box
    And user writes the comment
    Then user clicks the send comment button