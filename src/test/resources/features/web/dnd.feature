Feature: To use drag and drop feature
  Scenario: Drag  random components to dropbox and verify respective component in Dropped item list
    Given user is on respective page
    When user drag random component to dropbox box
    Then component must move to dropped item list