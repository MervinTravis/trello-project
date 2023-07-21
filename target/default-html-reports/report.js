$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CreateCardsThroughApiAndVerifyInUi.feature");
formatter.feature({
  "name": "Create a Board/List/Card through Trello API and perform some actions with created cards through UI",
  "description": "  As a user of the Trello API and Trello UI\n  I want to be able to create cards through the API and perform some actions with created cards through UI\n  So that I can manage my tasks seamlessly",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@wip"
    }
  ]
});
formatter.scenario({
  "name": "Create a Board/List/Card through Trello API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@wip"
    },
    {
      "name": "@api"
    },
    {
      "name": "@ignore"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user has  a valid Trello API key and token",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_has_a_valid_Trello_API_key_and_token()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user creates a new Trello board with the name \"IT Project Management\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_creates_a_new_Trello_board_with_the_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the board should be created successfully with name \"IT Project Management\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.the_board_should_be_created_successfully_with_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.response_status_code_should_be(int)"
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
  "name": "user creates a new list with name \"Unassigned\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_creates_a_new_list_with_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list should be created successfully with name \"Unassigned\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.the_list_should_be_created_successfully_with_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.response_status_code_should_be(int)"
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
        "Define Project Scope and Objectives",
        "Conduct Meetings with Stakeholders",
        "Obtain Approval from Key Stakeholders",
        "Monitor System Rollout Progress"
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
  "name": "response status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.response_status_code_should_be(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the response body should contain the created cards with following names:",
  "rows": [
    {
      "cells": [
        "Define Project Scope and Objectives",
        "Conduct Meetings with Stakeholders",
        "Obtain Approval from Key Stakeholders",
        "Monitor System Rollout Progress"
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
  "name": "Performing some actions with created cards through Trello UI",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@wip"
    },
    {
      "name": "@ui"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged into Trello.com with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_is_logged_into_Trello_com_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the board \"IT Project Management\"",
  "keyword": "When "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_clicks_the_board(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the newly created list in Trello board page with name \"Unassigned\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_should_see_the_newly_created_list_in_Trello_board_page_with_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user opens the card with the name \"Obtain Approval from Key Stakeholders\"",
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
  "name": "user moves the card on the position 1",
  "keyword": "And "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_moves_the_card_on_the_position(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the new position 1 of the card \"Obtain Approval from Key Stakeholders\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCardsStepDefs.user_verifies_the_new_position_of_the_card(int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/InvalidLogin.feature");
formatter.feature({
  "name": "User in valid Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ui"
    }
  ]
});
formatter.scenario({
  "name": "Invalid Login with valid email and invalid password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ui"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_is_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks login button",
  "keyword": "When "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_clicks_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Then "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters his valid email addresse \"unzertrellotask@gmail.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_enters_his_valid_email_addresse(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks the fortfahren button",
  "keyword": "And "
});
formatter.match({
  "location": "InvalidLoginStepdefs.clicks_the_fortfahren_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters an invalid password \"invalidpassword123\"",
  "keyword": "Then "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_enters_an_invalid_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the login button",
  "keyword": "And "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_clicks_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see an error message \"Einloggen, um fortzufahren\"",
  "keyword": "Then "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_should_see_an_error_message(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user remains on the login page",
  "keyword": "And "
});
formatter.match({
  "location": "InvalidLoginStepdefs.user_remains_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});