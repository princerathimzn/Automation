
Feature: Test IRCTC Scenarios

  Scenario: To verify user is able to search the train
    And I enter source as "Delhi" and destianation as "Mumbai"
    And I select class "First class"

  Scenario: Go to Google
    Given I am on google