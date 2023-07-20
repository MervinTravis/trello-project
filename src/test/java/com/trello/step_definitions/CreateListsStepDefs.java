package com.trello.step_definitions;

import com.trello.pages.BoardPage;
import com.trello.pages.DashBoardPage;
import com.trello.pages.HomePage;
import com.trello.pages.LoginPage;
import com.trello.utilities.ConfigurationReader;
import com.trello.utilities.Driver;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;


public class CreateListsStepDefs {

    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BoardPage boardPage = new BoardPage();
    private static final String API_KEY = ConfigurationReader.get("key");
    private static final String API_TOKEN = ConfigurationReader.get("token");
    private Response response;

    private static String idBoard;
    private static String boardName;

    private final Map<String, String> boardsMap = new HashMap<>();

    private static String listId;

    @Given("the user has a Trello board with the name {string}")
    public void the_user_has_a_Trello_board_with_the_name(String boardName) {

        response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("name", boardName)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .post("/boards/");

        // and extract the board ID and name from the response
        idBoard = response.path("id");
        System.out.println("idboard from response = " + idBoard);
        boardsMap.put(boardName, idBoard);
    }

    //getter for the idBoard
    public String getIdBoard() {
        return idBoard;
    }

    @When("the user send a POST request with the list name {string}")
    public void the_user_send_a_POST_request_with_the_list_name(String listName) {

        response = given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("idBoard", idBoard)
                .queryParam("name", listName)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .post("/lists");
        // and extract the list ID from the response
        listId = response.path("id");
        System.out.println("listId from response = " + listId);
        System.out.println("actualStatusCode from response = " + response.statusCode());

    }

    public String getlistId() {
        return listId;
    }

    @Then("the list should be created successfully with name {string}")
    public void the_list_should_be_created_successfully_with_name(String expectedListName) {
        String actualListName = response.path("name");
        Assert.assertNotNull(actualListName);
        Assert.assertEquals(expectedListName, actualListName);
    }

    @Given("user should see the newly created lists in Trello board page with name {string}")
    public void user_should_see_the_newly_created_lists_in_Trello_board_page_with_name(String expectedListName) throws InterruptedException {
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
}
