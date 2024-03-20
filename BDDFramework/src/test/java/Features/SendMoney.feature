@SendMoney
Feature: "Application login"

  Background: Verify user login is Successful with valid credentials.
    Given navigate to login page URL
    When  Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button


  @successfulTransaction @Regression
  Scenario Outline: Successful transaction via Bank account to card with valid inputs.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And selects receiver from list and clicks on confirm transfer button.
    And clicks on Send Money button
    Then verify Transaction Successful message is displayed.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       | United States | 10000     |

  @InsufficientFund
  Scenario Outline: Verify error message is displayed for Insufficient funds
  when user attempt for transaction with amount greater than account balance.
  transaction
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And selects receiver from list and clicks on confirm transfer button.
    And clicks on Send Money button
    Then verify error message is displayed for insufficient funds and transaction is failed.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       | United Kingdom | 50000    |


  @TxnDetails
  Scenario Outline: Verify transaction details amount,exchange rate, transfer fee, Total amount are displayed accurately.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    Then verify transaction details are displayed in the summary

  Examples:
    | sendFromCountry | sendToCountry | txnAmount |
    |     India       | Japan         | 5000      |


  @txnWithoutReceiver
  Scenario Outline: Verify Error Message Displayed if user attempts to proceed transaction without selecting Receiver.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And without selecting receiver clicks on confirm transfer button.
    Then verify error message displayed for select the receiver.


    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       | South Korea | 3000    |


  @successfulTransaction @transactionHistory
  Scenario Outline: Successful transaction via Bank account to card and transaction is recorded in history.
    When user selects send from country "<sendFromCountry>" and selects to country as "<sendToCountry>".
    And enter send amount as <txnAmount> and clicks on convert button.
    And select bank account payment method for payout and card method as payin and clicks On continue Button.
    And selects receiver from list and clicks on confirm transfer button.
    And clicks on Send Money button
    Then verify Transaction Successful message is displayed.
    And navigate to transaction history and verify transaction is recorded.

    Examples:
      | sendFromCountry | sendToCountry | txnAmount |
      |     India       | Italy         | 5000    |