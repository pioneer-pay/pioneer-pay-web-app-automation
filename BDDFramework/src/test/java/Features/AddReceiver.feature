@addReceiver
Feature: "Add Receiver"

  Background: Verify user login is Successful with valid credentials.
    Given navigate to login page URL
    When  Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button

  @validDetails
  Scenario Outline: New receiver successfully registered with valid inputs.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And clicks on Add new receiver button
    And enters the following receiver details and Clicks on Save button:
    |     bankName      | receiverName  | accountNumber | ifscCode| amount|
    |     Union Bank |       Dipak      | 20019873090   | UNION01 | 20000 |
    Then verify message for receiver registered successfully.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |        India     |  United States | 30000      |

  @invalidDetails
  Scenario Outline: Unsuccessful receiver registration due to invalid account number.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And clicks on Add new receiver button
    And enters the following receiver details and Clicks on Save button:
      |     bankName      | receiverName  | accountNumber | ifscCode | amount |
      |     Uco Bank      |  John Doe     |   2001       | UCO01    |  20000  |
    Then verify error message displayed for invalid Details.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |        India     |  United States | 30000   |


  @invalidDetails @alphanumeric
  Scenario Outline: Unsuccessful receiver registration due to invalid account number and Name.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And clicks on Add new receiver button
    And enters the following receiver details and Clicks on Save button:
      |     bankName    | receiverName  | accountNumber | ifscCode| amount|
      |     MGB         |    User21829   |   Test19029    | MGB01  | 20000 |
    Then verify error message displayed for invalid Details.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       |   Japan       | 30000     |


  @invalidDetails @negativeAmount
  Scenario Outline: Unsuccessful receiver registration due to user enters negative account balance.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And clicks on Add new receiver button
    And enters the following receiver details and Clicks on Save button:
      |     bankName    | receiverName  | accountNumber | ifscCode| amount|
      |     MGB         |    John Doe   |   Test19029    | MGB01  | 20000 |
    Then verify error message displayed for user entered invalid amount.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       |   Japan       | 30000     |

  @invalidDetails @amountLimitExceed
  Scenario Outline: Unsuccessful receiver registration due to user enters account balance beyond the limit.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And clicks on Add new receiver button
    And enters the following receiver details and Clicks on Save button:
      |     bankName    | receiverName  | accountNumber | ifscCode| amount|
      |     SBI         |    John Roy   |   Test19029    | MGB01  | 2000000000000000000000000000000000000000 |
    Then verify error message displayed for user entered invalid amount.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       |   Japan       | 30000     |
