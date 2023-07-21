@ui
Feature: User invalid Login

  Scenario: Invalid Login with valid email and invalid password
    Given user is on the home page
    When user clicks login button
    Then user is on the login page
    And  user enters his valid email addresse "unzertrellotask@gmail.com"
    And clicks the fortfahren button
    Then user enters an invalid password "invalidpassword123"
    And user clicks the login button
    Then user should see an error message "Einloggen, um fortzufahren"
    And user remains on the login page