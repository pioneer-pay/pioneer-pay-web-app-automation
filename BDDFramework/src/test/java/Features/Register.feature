
Feature: "Application Register"

  @WebsiteRegistration
  Scenario: verify user is successfully register with valid credentials
    Given navigate to registration page URL
    When user click on register tab
    And user enters email
    And user mention password
    And user clicks on register button
    Then verify user registered successfully
    And click on ok button

