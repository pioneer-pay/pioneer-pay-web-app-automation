Feature: "Account Details Update"

  Background: Verify user login is Successful with valid credentials.
    Given navigate to login page URL
    When Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button

  @AccountDetailsUpdate
  Scenario Outline: verify successful account details update with valid information
    Given clicks on my profile and go to the account details update
    And  fill all required details with valid information "<Account Holder Name>" "<Bank Name>" "<Account Number>" "<IFSC code>" "<Initial Balance>"
    And clicks on update button
    Then verify updated account details

    Examples:
      | Account Holder Name  | Bank Name | Account Number | IFSC code | Initial Balance |
      | Vikas Kadam          | State Bank | 83574632      | SBIN00032 | 2000            |

  @AccountDetailsUpdate
  Scenario Outline: verify tooltip message for account number and ifsc code
    Given click on my profile and go to the account details update
    And  fill all required details with invalid information "<Account Holder Name>" "<Bank Name>" "<Account Number>" "<IFSC code>" "<Initial Balance>"
    And clicks on update button of account details
    Then verify error messages
    Examples:
      | Account Holder Name  | Bank Name | Account Number | IFSC code | Initial Balance |
      | Vikas Kadam          | State Bank | 2      | SB | 0.0            |