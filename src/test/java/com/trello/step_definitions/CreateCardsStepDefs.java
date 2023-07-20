package com.trello.step_definitions;

import com.trello.pages.BoardPage;
import com.trello.pages.DashBoardPage;
import com.trello.pages.HomePage;
import com.trello.pages.LoginPage;
import com.trello.utilities.ConfigurationReader;
import com.trello.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CreateCardsStepDefs {
    JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BoardPage boardPage = new BoardPage();
    private static final String API_KEY = ConfigurationReader.get("key");
    private static final String API_TOKEN = ConfigurationReader.get("token");

    Response response;
    private static final Map<String, String> mapOfBoards = new HashMap<>();
    private static String idBoard;

    private static String boardName;
    private static String listId;

    private static String cardId;

    private static String cardName;

   final List<String> actualCardNames = new ArrayList<>();

    @Given("user has  a valid Trello API key and token")
    public void user_has_a_valid_Trello_API_key_and_token() {
        //no action required
    }

    @Given("user creates a new Trello board with the name {string}")
    public void user_creates_a_new_Trello_board_with_the_name(String boardNameToBeCreated) {
        response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("name", boardNameToBeCreated)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .post("/boards/");

        // and extract the board ID and name from the response
        idBoard = response.path("id");
        boardName = response.path("name");
        System.out.println("idboard from response = " + idBoard);
        System.out.println("boardName from response = " + boardName);
        mapOfBoards.put(boardName, idBoard);
        System.out.println("mapOfBoards boardname = " + mapOfBoards.get(boardName));
        System.out.println("mapOfBoards idboard = " + mapOfBoards.get(idBoard));
    }

    @And("the board should be created successfully with name {string}")
    public void the_board_should_be_created_successfully_with_name(String expectedBoardName) {

        for (Map.Entry<String, String> entry : mapOfBoards.entrySet()) {
            String actualBoardName = entry.getKey();
            Assert.assertEquals(expectedBoardName, actualBoardName);
        }
    }

    @Given("user has the board id from the response body")
    public void user_has_the_board_id_from_the_response_body() {
        //no action required

    }
    @Given("user creates a new list with name {string}")
    public void user_creates_a_new_list_with_name(String listNameToBeCreated) {
        response = given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("idBoard", idBoard)
                .queryParam("name", listNameToBeCreated)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .post("/lists");
        // and extract the list ID from the response
        listId = response.path("id");
        System.out.println("listId from response = " + listId);
        System.out.println("actualStatusCode from response = " + response.statusCode());

    }

    @Then("the list should be created successfully with name {string}")
    public void the_list_should_be_created_successfully_with_name(String expectedListName) {
        String actualListName = response.path("name");
        Assert.assertNotNull(actualListName);
        Assert.assertEquals(expectedListName, actualListName);
    }

    @Given("user has the list id from the response body")
    public void user_has_the_list_id_from_the_response_body() {
        //no action required
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

    @Then("response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
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

    @Given("user is logged into Trello.com with valid credentials")
    public void user_is_logged_into_Trello_com_with_valid_credentials() throws InterruptedException {

        //open home page
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Thread.sleep(2000);
        String actualHomePageTitle = Driver.get().getTitle();
        String expectedHomePageTitle = "Manage Your Team’s Projects From Anywhere | Trello";
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        Thread.sleep(3000);
        homePage.alleCookiesAkzeptieren.click();

        //click on Log in button and open login page
        Thread.sleep(2000);
        homePage.loginButton.click();
        String actualLoginPageTitle = Driver.get().getTitle();
        String expectedLoginPageTitle = "Bei Trello anmelden";
        Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
        Thread.sleep(2000);

        //enter a valid email address and password and logged in
        String userEmail = ConfigurationReader.get("email");
        loginPage.emailInputField.sendKeys(userEmail);
        loginPage.fortfahrenButton.click();
        Thread.sleep(2000);
        String password = ConfigurationReader.get("password");
        loginPage.passwordInputField.sendKeys(password);
        Thread.sleep(2000);
        loginPage.einloggenButton.click();
        Thread.sleep(3000);

        //user is on the dashboard page
        String actualDashboardUrl = Driver.get().getCurrentUrl();
        String expectedDashboardUrl = "https://trello.com/u/unzerusertask/boards";
        Assert.assertEquals(expectedDashboardUrl, actualDashboardUrl);

    }
    @Then("user clicks the board {string}")
    public void user_clicks_the_board(String expectedBoardName) {
        List<WebElement> allBoardNames = dashBoardPage.boardsList;
        for (WebElement boardName : allBoardNames) {
            if (expectedBoardName.equals(boardName.getText())) {
                boardName.click();
                break;
            }
        }
    }

    @Given("user should see the newly created list in Trello board page with name {string}")
    public void user_should_see_the_newly_created_list_in_Trello_board_page_with_name(String expectedListName) throws InterruptedException {
        List<WebElement> allLists = boardPage.allLists;
        wait.until(ExpectedConditions.visibilityOfAllElements(allLists));
        for (WebElement listName : allLists) {
            wait.until(ExpectedConditions.visibilityOf(listName));
            if (listName.getText().equals(expectedListName)) {
                return;
            }
        }
        throw new AssertionError("expectedListName not found in the board ");
    }

    @Then("user opens the card with the name {string}")
    public void user_opens_the_card_with_the_name(String expectedCardName) {
        List<WebElement> allCards = boardPage.allCardsCss;
        wait.until(ExpectedConditions.visibilityOfAllElements(allCards));
        for (WebElement cardName : allCards) {
            System.out.println("cardName from board page= " + cardName.getText());
            wait.until(ExpectedConditions.visibilityOf(cardName));
            if (cardName.getText().equals(expectedCardName)) {
                System.out.println("cardName from if block  = " + cardName.getText());
                cardName.click();
            }
        }
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

    @Then("user verifies the new position {string} of the card {string}")
    public void user_verifies_the_new_position_of_the_card(String expectedPosition, String card) {
        List<WebElement> allCards = boardPage.allCardsCss;
            wait.until(ExpectedConditions.visibilityOfAllElements(allCards));
            for (WebElement cardName : allCards) {
                 wait.until(ExpectedConditions.visibilityOf(cardName));
                 if (cardName.getText().equals(card)) {
                    cardName.click();
                 }
            }
             boardPage.moveCardButton.click();
             Select select = new Select(boardPage.cardPosition);
             String actualPosition = select.getFirstSelectedOption().getText();
             System.out.println("actualPosition of the card= " + actualPosition);
             Assert.assertTrue(actualPosition.contains(expectedPosition));
             boardPage.cardDialogCloseBtn.click();

    }

}
