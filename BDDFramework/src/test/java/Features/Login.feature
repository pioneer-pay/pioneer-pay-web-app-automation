@WebsiteLogin
Feature: "Application login"

  Scenario: Verify user login is Successful with valid credentials.
    Given navigate to login page URL "ExtendedHomeUrl"
    When Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button
