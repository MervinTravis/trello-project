@smoke @wip
Feature: Create a Board/List/Card through Trello API and perform some actions with created cards through UI
  As a user of the Trello API and Trello UI
  I want to be able to create cards through the API and perform some actions with created cards through UI
  So that I can manage my tasks seamlessly

  @api @ignore
  Scenario: Create a Board/List/Card through Trello API
    Given user has  a valid Trello API key and token
    And  user creates a new Trello board with the name "IT Project Management"
    And the board should be created successfully with name "IT Project Management"
    Then response status code should be 200
    Given user has the board id from the response body
    And user creates a new list with name "Unassigned"
    And the list should be created successfully with name "Unassigned"
    Then response status code should be 200
    Given user has the list id from the response body
    When  user send a POST request to create cards with following names:
      |Define Project Scope and Objectives|Conduct Meetings with Stakeholders| Obtain Approval from Key Stakeholders|Monitor System Rollout Progress|
    Then response status code should be 200
    And the response body should contain the created cards with following names:
      |Define Project Scope and Objectives|Conduct Meetings with Stakeholders| Obtain Approval from Key Stakeholders|Monitor System Rollout Progress|

  @ui
  Scenario: Performing some actions with created cards through Trello UI
    Given user is logged into Trello.com with valid credentials
    When user clicks the board "IT Project Management"
    Then user should see the newly created list in Trello board page with name "Unassigned"
    And  user opens the card with the name "Obtain Approval from Key Stakeholders"
    And user clicks on the add member button
    And user searches the text "unzertrellotask" in the search input field
    And user adds new member with the name "unzertrellotask" to the card
    And user closes the member dialog
    And user verifies the newly added member "unzertrellotask"
    Then user deletes the newly added member from the card
    And user moves the card on the position 1
    Then user verifies the new position 1 of the card "Obtain Approval from Key Stakeholders"

