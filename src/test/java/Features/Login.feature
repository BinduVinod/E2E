Feature: Login Feature
  This feature deals with Login to Execute Automation page
  @Login
  Scenario:Login with correct username and password
    Given I am in the login page
    When I enter the login details
      | emailID                | password |
      | bindoos.sekhar@gmail.com | abcd1234 |
    And I enter the login button
    Then I should see the course page


