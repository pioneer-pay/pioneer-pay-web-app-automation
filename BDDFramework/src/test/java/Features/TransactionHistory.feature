@WebsiteTransactionHistory
Feature: "Application login and Application Transaction History"

  Background: Verify user login is Successful with valid credentials.
    Given navigate to login page URL
    When Click on link for Log In
    And User enters email and password
    And user clicks on continue
    Then verify user logged in successfully
    And user click on ok button

  Scenario: User verifies transaction history after sending money
    Given the user is logged in to the transaction history module
    When the user navigates to the transaction history section
    And verify the transaction history should include details such as id,From account,To account,Date&Time,Transaction Amount,Commission,Recieved amount  and status
    Then the user should see list of previous transaction
