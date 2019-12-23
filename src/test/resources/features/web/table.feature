Feature: To calculate entries in a table
  Scenario: Calculate number of entries from table, keeping 10 entries per page and verify it with number of entries displayed at bottom
    Given User is on table page
    When user calculates entries from the table
    Then number of entries comes equals to the total number of entries displayed at the bottom of the table