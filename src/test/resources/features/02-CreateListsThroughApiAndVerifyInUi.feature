
Feature: Creating a List through Trello API
  As a user of the Trello API
  I want to be able to create a new list on a Trello board
  So that I can organize my tasks effectively

  @api @ignore
  Scenario: Create a new list on a Trello board
    Given user has  a valid Trello API key and token
    And the user has a Trello board with the name "SPRINT"
    When the user send a POST request with the list name "UNASSIGNED"
    #Then response status code should be 200
    And the list should be created successfully with name "UNASSIGNED"


  @ui
  Scenario: Verifying List Creation in Trello UI
    Given user is logged into Trello.com with valid credentials
    When user clicks the board "SPRINT"
    Then user should see the newly created lists in Trello board page with name "UNASSIGNED"




