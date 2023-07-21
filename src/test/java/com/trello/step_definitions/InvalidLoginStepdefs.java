package com.trello.step_definitions;

import com.trello.pages.HomePage;
import com.trello.pages.LoginPage;
import com.trello.utilities.ConfigurationReader;
import com.trello.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidLoginStepdefs {

    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Given("user is on the home page")
    public void user_is_on_the_home_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Thread.sleep(3000);
        String actualHomePageTitle = Driver.get().getTitle();
        String expectedHomePageTitle = "Manage Your Team’s Projects From Anywhere | Trello";
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        Thread.sleep(3000);
        homePage.alleCookiesAkzeptieren.click();
    }

    @When("user clicks login button")
    public void user_clicks_login_button() throws InterruptedException {
        Thread.sleep(2000);
        homePage.loginButton.click();
    }

    @Then("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        String actualLoginPageTitle = Driver.get().getTitle();
        String expectedLoginPageTitle = "Bei Trello anmelden";
        Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
        Thread.sleep(2000);
    }

    @Then("user enters his valid email addresse {string}")
    public void user_enters_his_valid_email_addresse(String emailAddresse) {
        String userEmail = ConfigurationReader.get("email");
        loginPage.emailInputField.sendKeys(userEmail);

    }

    @Then("clicks the fortfahren button")
    public void clicks_the_fortfahren_button() throws InterruptedException {
        loginPage.fortfahrenButton.click();
        Thread.sleep(2000);
    }

    @Then("user enters an invalid password {string}")
    public void user_enters_an_invalid_password(String invalidPassword) throws InterruptedException {
        loginPage.passwordInputField.sendKeys(invalidPassword);
        Thread.sleep(2000);
    }

    @Then("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.einloggenButton.click();
    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String errorMessage) {
        String actualErrorMessage = loginPage.errorMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals(errorMessage, actualErrorMessage);
    }    

    @Then("user remains on the login page")
    public void user_remains_on_the_login_page() {
        String actualLoginPageTitle = Driver.get().getTitle();
        System.out.println("actualLoginPageTitle = " + actualLoginPageTitle);
        String expectedLoginPageTitle = "Einloggen, um fortzufahren - Mit Atlassian-Konto einloggen";
        Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
    }

}
