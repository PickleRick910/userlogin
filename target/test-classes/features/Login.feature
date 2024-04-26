Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username
    And the user enters their password
    And the user clicks the sign in button
    Then the user should be redirected to the homepage
    And a welcome message should be displayed
