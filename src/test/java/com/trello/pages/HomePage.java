package com.trello.pages;

import com.trello.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath= "//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")
    public WebElement loginButton;

    @FindBy(xpath= "//button[text()='Alle Cookies akzeptieren']")
    public WebElement alleCookiesAkzeptieren;
}
