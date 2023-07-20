package com.trello.pages;

import com.trello.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//*[@id=\"user\"]")
    public WebElement emailInputField;

    @FindBy(xpath="//*[@id=\"password\"]")
    public WebElement passwordInputField;

    @FindBy(xpath="//input[@id='login']")
    public WebElement fortfahrenButton;

    @FindBy(xpath = "//span[text()='Einloggen']")
    public WebElement einloggenButton;
}
