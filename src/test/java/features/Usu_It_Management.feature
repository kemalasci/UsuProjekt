Feature:Usu It Service Management page functionality

  @smoke
  Scenario: User should be able to use Usu It Service Management Page functionality
    Given User should be able to navigate to homePage
    When Usu It Service Management should be clickable
    Then  User should be able to go to Usu It Service Management web page
    And The user should be able to fill the web presentation form
    Then the user should be able to click the Submit button
    And The user should be able to see the Error text

