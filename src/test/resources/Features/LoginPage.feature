Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given User is on login page
    When user enters valid Email and Password
    And Click on "Log in" button
    Then User should navigate to homepage
    And Page Title should be "Dashboard / nopCommerce administration"
