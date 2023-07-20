@wip
Feature: Creating Cards in Trello API and Verifying in Trello UI
  As a user of the Trello API and Trello UI
  I want to be able to create cards through the API and verify their presence in the Trello UI
  So that I can manage my tasks seamlessly

  Scenario: Create a Card through Trello API and Verify in Trello UI
    Given user has  a valid Trello API key and token
    And the user has a Trello board with the name "NEW BOARD"
    Given user has the board id from the response body
    And the user send a POST request with the list name "NEW LIST"
    Given user has the list id from the response body
    When  user send a POST request to create cards with following names:
    |NEW CARD| OLD CARD| ANCIENT CARD|A|B|
    #Then response status code should be 200
    And the response body should contain the created cards with following names:
    |NEW CARD| OLD CARD| ANCIENT CARD|A|B|
    #And user deletes the the created board with the  name "HAYDEEE"

  Scenario: Verifying Card Creation in Trello UI
    Given user is logged into Trello.com with valid credentials
    When user clicks the board "NEW BOARD"
    Then user should see the newly created lists in Trello board page with name "NEW LIST"
    And  user opens the card with the name "NEW CARD"
    And user clicks on the add member button
    And user searches the text "unzertrellotask" in the search input field
    And user adds new member with the name "unzertrellotask" to the card
    And user closes the member dialog
    And user verifies the newly added member "unzertrellotask"
    Then user deletes the newly added member from the card
    And user moves the card on the position 5
    Then user verifies the new position of the card "5"

