package com.trello.step_definitions;

import com.trello.pages.BoardPage;
import com.trello.pages.DashBoardPage;
import com.trello.pages.HomePage;
import com.trello.pages.LoginPage;
import com.trello.utilities.ConfigurationReader;
import com.trello.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CreateCardsStepDefs {
    JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
    CreateListsStepDefs createListsStepDefs = new CreateListsStepDefs();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BoardPage boardPage = new BoardPage();
    private static final String API_KEY = ConfigurationReader.get("key");
    private static final String API_TOKEN = ConfigurationReader.get("token");

    Response response;
    private static String idBoard;
    private static String listId;

    private static String cardId;

    private static String cardName;

   final List<String> actualCardNames = new ArrayList<>();

    @Given("user has the board id from the response body")
    public void user_has_the_board_id_from_the_response_body() {
        idBoard = createListsStepDefs.getIdBoard();
        System.out.println("idBoard  from create list class= " + idBoard);
    }

    @Given("user has the list id from the response body")
    public void user_has_the_list_id_from_the_response_body() {
        listId = createListsStepDefs.getlistId();
        System.out.println("idList  from create list class= " + listId);
    }

    @When("user send a POST request to create cards with following names:")
    public void user_send_a_POST_request_to_create_cards_with_following_names(io.cucumber.datatable.DataTable table) {
        List<String> cards = table.asList(String.class);
        for (String card:cards) {
            System.out.println("card from data table= " + card);
            response = given().log().all()
                    .queryParam("idList", listId)
                    .queryParam("name", card)
                    .queryParam("key", API_KEY)
                    .queryParam("token", API_TOKEN)
                    .contentType(ContentType.JSON)
                    .post("/cards");

            cardId = response.path("id");
            System.out.println("cardId from response= " + cardId);
            actualCardNames.add(response.path("name"));

        }
    }

    @When("the response body should contain the created cards with following names:")
    public void the_response_body_should_contain_the_created_cards_with_following_names(DataTable table) {
        List<String> tableCards = table.asList(String.class);

        for (int i=0; i<tableCards.size(); i++){
            String actualCardName = actualCardNames.get(i);
            String expectedCardName = tableCards.get(i);
            System.out.println("expected card name from data table= " + expectedCardName);
            System.out.println("actualCardName from response = " + actualCardName);
            Assert.assertEquals(expectedCardName, actualCardName);
        }

    }

    @Then("user opens the card with the name {string}")
    public void user_opens_the_card_with_the_name(String expectedCardName) {
        List<WebElement> allCards = boardPage.allCardsCss;
        wait.until(ExpectedConditions.visibilityOfAllElements(allCards));
        for (WebElement cardName : allCards) {
            wait.until(ExpectedConditions.visibilityOf(cardName));
            if (cardName.getText().equals(expectedCardName)) {
                cardName.click();
            }
        }
        //throw new AssertionError("expectedCardName not found in the board ");

    }

    @Then("user clicks on the add member button")
    public void user_clicks_on_the_add_member_button() {
        wait.until(ExpectedConditions.elementToBeClickable(boardPage.changeCardMember));
        boardPage.changeCardMember.click();
    }

    @Then("user searches the text {string} in the search input field")
    public void user_searches_the_text_in_the_search_input_field(String memberToBeSearch) {
       wait.until(ExpectedConditions.elementToBeClickable(boardPage.inputSearchMember));
        boardPage.inputSearchMember.sendKeys(memberToBeSearch);
    }

    @Then("user adds new member with the name {string} to the card")
    public void user_adds_new_member_with_the_name_to_the_card(String memberToBeAdded) {
        wait.until(ExpectedConditions.visibilityOf(boardPage.addMember));
        boardPage.addMember.getText();
        boardPage.addMember.click();
    }

    @Then("user closes the member dialog")
    public void user_closes_the_member_dialog() {
        boardPage.addMemberDialogCloseBtn.click();
    }

    @Then("user verifies the newly added member {string}")
    public void user_verifies_the_newly_added_member(String newMember) {
        boardPage.memberOnCardMenu.click();
        Assert.assertEquals(boardPage.memberTitle.getText(),newMember);

    }

    @Then("user deletes the newly added member from the card")
    public void user_deletes_the_newly_added_member_from_the_card() {
        boardPage.removeFromCardBtn.click();
    }

    @Then("user moves the card on the position {int}")
    public void user_moves_the_card_on_the_position(Integer newPositionOfTheCard) {
        wait.until(ExpectedConditions.elementToBeClickable(boardPage.moveCardButton));
        boardPage.moveCardButton.click();
        Select select = new Select(boardPage.cardPosition);
        select.selectByIndex(newPositionOfTheCard-1);
        boardPage.moveCardSubmitBtn.click();
        boardPage.cardDialogCloseBtn.click();
    }

    @Then("user verifies the new position of the card {string}")
    public void user_verifies_the_new_position_of_the_card(String expectedPosition) {
        List<WebElement> allCards = boardPage.allCardsCss;
        wait.until(ExpectedConditions.visibilityOfAllElements(allCards));
        for (WebElement cardName : allCards) {
            wait.until(ExpectedConditions.visibilityOf(cardName));
            if (cardName.getText().equals("NEW CARD")) {
                cardName.click();
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(boardPage.moveCardButton));
        boardPage.moveCardButton.click();
        Select select = new Select(boardPage.cardPosition);
        String actualPosition = select.getFirstSelectedOption().getText();
        //String actualPosition = boardPage.cardPosition.getAttribute("selected");
        System.out.println("actualPosition of the card= " + actualPosition);
        Assert.assertTrue(actualPosition.contains(expectedPosition));
        boardPage.cardDialogCloseBtn.click();

    }

}
