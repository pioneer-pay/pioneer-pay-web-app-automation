Feature: "Profile Update"
  @UpdateProfile
  Scenario Outline: verify successful update profile with valid details
    Given login pioneer pay application and click on my profile
    And  fill all required details "<first name>"
    And click on update
    Then verify updated profile


    Examples:
      | first name  |
      | Dipak       |

