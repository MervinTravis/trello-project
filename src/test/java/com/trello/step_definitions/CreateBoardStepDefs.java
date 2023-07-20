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
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class CreateBoardStepDefs {

    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BoardPage boardPage = new BoardPage();
    private static final String API_KEY = ConfigurationReader.get("key");
    private static final String API_TOKEN = ConfigurationReader.get("token");
    Response response;
    String boardName;
    static String idBoard;
    final Map<String, String> mapOfBoards = new HashMap<>();
    static final Map<String, String> allBoardsCreated = new HashMap<>();

    static  final  List<String> boardIds = new ArrayList<>();


    @Given("user has  a valid Trello API key and token")
    public void user_has_a_valid_Trello_API_key_and_token() {
        // No action needed as it's set in class level

    }

    @Given("The user send a POST request with the name {string}")
    public void the_user_send_a_POST_request_with_the_name(String boardName) {
        this.boardName = boardName;
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("name", boardName)
                .queryParam("defaultLists", false)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .post("/boards/");

        // and extract the board ID and name from the response
        idBoard = response.path("id");
        boardName = response.path("name");
        System.out.println("**********************");
        int actualStatusCode = response.statusCode();
        System.out.println("actualStatusCode = " + actualStatusCode);
        System.out.println("**********************");

        // Store the board ID in the map with the corresponding board name
        mapOfBoards.put(boardName, idBoard);
        System.out.println("***********************************");
        allBoardsCreated.put(boardName,idBoard);
        System.out.println("boardName = " + boardName);
        System.out.println("boardId = " + idBoard);
        System.out.println("allBoardsCreated.size() = " + allBoardsCreated.size());
        System.out.println("***********************************");


    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("the board should be created successfully with name {string}")
    public void the_board_should_be_created_successfully_with_name(String expectedBoardName) {

        for (Map.Entry<String, String> entry : mapOfBoards.entrySet()) {
            boardName = entry.getKey();
            Assert.assertEquals(boardName, expectedBoardName);
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

    @And("user should see the newly created boards in Trello dashboard with name {string}")
    public void user_should_see_the_newly_created_boards_in_Trello_dashboard_with_name(String expectedBoardName) {

        List<WebElement> allBoardNames = dashBoardPage.boardsList;
        wait.until(ExpectedConditions.visibilityOfAllElements(allBoardNames));
        for (WebElement boardName : allBoardNames) {
            if (boardName.getText().equals(expectedBoardName)) {
                return;
            }
        }
        throw new AssertionError("expectedBoardName not found in the dashboard page");
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

    @Then("user should see that the  board title is {string}")
    public void user_should_see_that_the_board_title_is(String expectedBoardTitle) {

        String actualBoardTitle = boardPage.boardTitle.getText();
        Assert.assertEquals(expectedBoardTitle, actualBoardTitle);

    }

    @Given("there is an existing board with the name {string} on Trello")
    public void there_is_an_existing_board_with_the_name_on_Trello(String expectedBoardName) {
        System.out.println("================================" );
        idBoard = allBoardsCreated.get(expectedBoardName);
        System.out.println("id board from allboardscreated map = " + idBoard);
        System.out.println("================================" );
    }

    @When("the user sends a DELETE request to the Trello API for the board")
    public void the_user_sends_a_DELETE_request_to_the_Trello_API_for_the_board() {
        //String id = allBoardsCreated.get(boardToBeDelete);
        //System.out.println("expectedBoardName = " + idBoard);
        System.out.println("id to be deleted = " + idBoard);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .delete("/boards/"+idBoard);
        int statusCodeAfterDeleting = response.statusCode();
        System.out.println("statusCodeAfterDeleting = " + statusCodeAfterDeleting);
    }

    @Then("the board {string} should no longer exist on Trello")
    public void the_board_should_no_longer_exist_on_Trello(String deletedBoardId) {
        boolean bool = response.body().asString().contains(deletedBoardId);
        System.out.println("bool = " + bool);
        Assert.assertFalse(response.body().asString().contains(deletedBoardId));
        System.out.println("the following board is no longer available  = " + deletedBoardId);
    }

    @Given("there is existing board id")
    public void there_is_existing_board_id() {

        for (Map.Entry<String, String> entry : allBoardsCreated.entrySet()) {
             boardIds.add(entry.getValue());
        }
    }

    @When("the user sends a DELETE request to the Trello API for all boards")
    public void the_user_sends_a_DELETE_request_to_the_Trello_API_for_all_boards() {
        for (int i = 0; i<boardIds.size(); i++) {
             String id = boardIds.get(i);
             response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .queryParam("key", API_KEY)
                    .queryParam("token", API_TOKEN)
                    .delete("/boards/" + id);
                int statusCodeAfterDeleting = response.statusCode();
                System.out.println("statusCodeAfterDeleting = " + statusCodeAfterDeleting);
        }
    }

    @Then("the boards should no longer exist on Trello")
    public void the_boards_should_no_longer_exist_on_Trello() {

    }
}