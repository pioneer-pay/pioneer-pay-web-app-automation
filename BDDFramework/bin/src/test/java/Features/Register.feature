
Feature: "Application Register"

  @WebsiteRegistration
  Scenario: verify user is successfully register with valid credentials
<<<<<<< HEAD
    Given navigate to registration page URL 
=======
    Given navigate to registration page URL
>>>>>>> 5bb5cf3b82924f9297de0a1469e58622acadeffb
    When user click on register tab
    And user enters email
    And user mention password
    And user clicks on register button
    Then verify user registered successfully
    And click on ok button

