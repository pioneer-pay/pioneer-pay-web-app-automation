
Feature: "Application login"

  @WebsiteLogin
  Scenario: Verify user login is Successful with valid credentials.
<<<<<<< HEAD
    Given navigate to login page URL 
=======
    Given navigate to login page URL
>>>>>>> 5bb5cf3b82924f9297de0a1469e58622acadeffb
    When Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button
