package com.trello.pages;

import com.trello.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoardPage {

    public BoardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//textarea[@class='list-header-name mod-list-name js-list-name-input']")
    public List<WebElement> allLists;

    @FindBy(css = "a[data-testid='trello-card']")
    public List<WebElement> allCardsCss;

    @FindBy(className = "js-select-position")
    public WebElement cardPosition;

    @FindBy(xpath = "//a[@title='Mitglieder']")
    public WebElement changeCardMember;

    @FindBy(xpath = "//input[@placeholder='Nach Benutzern suchen']")
    public WebElement inputSearchMember;

    @FindBy(xpath= "//a[@class='name js-select-member']")
    public WebElement addMember;

    @FindBy(xpath = "//div[@class='member js-member-on-card-menu']")
    public WebElement memberOnCards;

    @FindBy(xpath = "//div[@class='mlJgSuVgmFSDj4']")
    public WebElement memberTitle;
    @FindBy(xpath = "//ul/li[@data-testid='remove-from-card']")
    public WebElement removeFromCardBtn;

    @FindBy(xpath = "//a[@title='Verschieben']")
    public WebElement moveCardButton;

    @FindBy(xpath = "//input[@value='Verschieben']")
    public  WebElement moveCardSubmitBtn;

    @FindBy(xpath = "//a[@class='pop-over-header-close-btn icon-sm icon-close']")
    public WebElement addMemberDialogCloseBtn;

    @FindBy(xpath = "//a[@aria-label='Dialog schließen']")
    public  WebElement cardDialogCloseBtn;
}
