
Feature: Creating Board through Trello API and Verifying in Trello UI
  @api @ignore
  Scenario Outline: User creates new boards
    Given user has  a valid Trello API key and token
    When The user send a POST request with the name "<boardName>"
    Then response status code should be 200
    And the board should be created successfully with name "<boardName>"
   Examples:
      | boardName               |
      | Team Collaboration      |
      | Ideas and Brainstorming |
      | Product Development     |

  @ui
  Scenario: Verifying Board Creation in Trello UI
    Given user is logged into Trello.com with valid credentials
    And user should see the newly created boards in Trello dashboard with name "Ideas and Brainstorming"
    Then user clicks the board "Ideas and Brainstorming"
    And user should see that the  board title is "Ideas and Brainstorming"

  @api @ignore
  Scenario: User deletes the existing boards successfully
    Given user has  a valid Trello API key and token
    And there is an existing board with the name "Product Development" on Trello
    When the user sends a DELETE request to the Trello API for the board
    Then response status code should be 200
    And the board "Product Development" should no longer exist on Trello

  @api @ignore
  Scenario: User deletes  through Trello Api all the newly created boards successfully
    Given user has  a valid Trello API key and token
    And there is existing board id
    When the user sends a DELETE request to the Trello API for all boards
    Then response status code should be 200
    And the boards should no longer exist on Trello

