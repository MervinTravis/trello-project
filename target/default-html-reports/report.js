$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/03-CreateCardsThroughApiAndVerifyInUi.feature");
formatter.feature({
  "name": "Creating Cards in Trello API and Verifying in Trello UI",
  "description": "  As a user of the Trello API and Trello UI\n  I want to be able to create cards through the API and verify their presence in the Trello UI\n  So that I can manage my tasks seamlessly",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.scenario({
  "name": "Create a Card through Trello API and Verify in Trello UI",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user has  a valid Trello API key and token",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateBoardStepDefs.user_has_a_valid_Trello_API_key_and_token()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user has a Trello board with the name \"NEW BOARD\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateListsStepDefs.the_user_has_a_Trello_board_with_the_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user has the board id from the response body",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_has_the_board_id_from_the_response_body()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user send a POST request with the list name \"NEW LIST\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateListsStepDefs.the_user_send_a_POST_request_with_the_list_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user has the list id from the response body",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_has_the_list_id_from_the_response_body()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user send a POST request to create cards with following names:",
  "rows": [
    {
      "cells": [
        "NEW CARD",
        "OLD CARD",
        "ANCIENT CARD",
        "A",
        "B"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_send_a_POST_request_to_create_cards_with_following_names(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the response body should contain the created cards with following names:",
  "rows": [
    {
      "cells": [
        "NEW CARD",
        "OLD CARD",
        "ANCIENT CARD",
        "A",
        "B"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.the_response_body_should_contain_the_created_cards_with_following_names(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verifying Card Creation in Trello UI",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged into Trello.com with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateBoardStepDefs.user_is_logged_into_Trello_com_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the board \"NEW BOARD\"",
  "keyword": "When "
});
formatter.match({
  "location": "CreateBoardStepDefs.user_clicks_the_board(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the newly created lists in Trello board page with name \"NEW LIST\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateListsStepDefs.user_should_see_the_newly_created_lists_in_Trello_board_page_with_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user opens the card with the name \"NEW CARD\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_opens_the_card_with_the_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on the add member button",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_clicks_on_the_add_member_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user searches the text \"unzertrellotask\" in the search input field",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_searches_the_text_in_the_search_input_field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user adds new member with the name \"unzertrellotask\" to the card",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_adds_new_member_with_the_name_to_the_card(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes the member dialog",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_closes_the_member_dialog()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the newly added member \"unzertrellotask\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_verifies_the_newly_added_member(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user deletes the newly added member from the card",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_deletes_the_newly_added_member_from_the_card()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user moves the card on the position 5",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_moves_the_card_on_the_position(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the new position of the card \"5\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_verifies_the_new_position_of_the_card(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});