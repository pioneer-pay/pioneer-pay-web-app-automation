
Feature: "Application login"

  @WebsiteLogin
  Scenario: Verify user login is Successful with valid credentials.
    Given navigate to login page URL
    When Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button
