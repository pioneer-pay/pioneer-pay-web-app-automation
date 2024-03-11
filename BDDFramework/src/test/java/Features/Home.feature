Feature: "Application login"
  @Login
  Scenario: Verify user login is Successful with valid credentials.
    Given navigate to home page
    When  Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully modal is displayed.