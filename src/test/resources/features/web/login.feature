Feature: Using "Scenario outline"

  Scenario Outline: To perform all possible negative scenarios for login functionality of your project using "Scenario outline"
    Given User is on workorder web
    When user enters data as following "<Username>" and "<Password>"
    Then user must be redirected to login page
    Examples:
      | Username              | Password              |
      |                       |                       |
      |                       | 1234567890            |
      | sachin@mailinator.com | 1234567               |
      | sachin                | 1234567               |
      | sachin@mailinator.com |                       |
      | sachin@mailinator.com | 123456789012345678901 |
      | sachin                | 1234567890            |