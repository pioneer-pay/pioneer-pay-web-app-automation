Feature: "Profile Update"

  Background: Verify user login is Successful with valid credentials.
    Given navigate to login page URL
    When Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button

  @UpdateProfile
  Scenario Outline: verify successful update profile with valid details
    Given login pioneer pay application and click on my profile
    And  fill all required details "<first name>"
    And click on update
    Then verify updated profile


    Examples:
      | first name  |
      | Dipak       |

  @UpdateProfile
  Scenario: update profile with empty fields and verify error messages
    Given click on my profile
    And  fill all required details with invalid information
    And click on update button
    Then verify error messages.

  @UpdateProfile
  Scenario: update profile with long text, special characters field and verify error messages
    Given click on my profile button
    And  fill all details with long text information
    And clicks on update
    Then verify error message.
