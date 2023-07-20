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

    @FindBy(css = "h1[data-testid='board-name-display']")
    public WebElement boardTitle;


    @FindBy(xpath = "//textarea[@class='list-header-name mod-list-name js-list-name-input']")
                     //textarea[@class='list-header-name mod-list-name js-list-name-input']
    public List<WebElement> allLists;
    //  //div[@class='list-header js-list-header u-clearfix is-menu-shown ui-sortable-handle']
    // "list-header js-list-header u-clearfix is-menu-shown ui-sortable-handle"
    //  //div[@class='list-header-target js-editing-target']

    @FindBy(className = "list-card-title js-card-name")
    public List<WebElement> allCards;


    @FindBy(xpath = "//a[@class='list-header-extras-menu js-open-list-menu icon-sm icon-overflow-menu-horizontal']")
    public WebElement listHeaderMenu;

    @FindBy(xpath = "js-move-list")
    public WebElement moveList;

    @FindBy(className = "js-add-card")
    public WebElement addCard;

    /*
    @FindBy(xpath = "//a[@data-testid='quick-card-editor-move']")
    public WebElement moveCard;

     */

    @FindBy(css = "a[data-testid='trello-card']")
    public List<WebElement> allCardsCss;

    @FindBy(xpath = "//*[@id=\"chrome-container\"]/div[7]/div/div[2]/a[1]")
    public WebElement openCard;

    @FindBy(className = "js-select-position")
    public WebElement cardPosition;

    @FindBy(xpath = "//input[@value='Verschieben']")
    public  WebElement moveButton;

    @FindBy(xpath = "//p[@class='u-bottom js-hide-with-desc']/a[text()='Detaillierte Beschreibung hinzufügen …']")
    public WebElement cardDescTextArea;
    @FindBy(xpath = "//p/span[@data-testid='placeholder-test-id']")
    public WebElement placeholderText;

    @FindBy(xpath = "//a[@title='Mitglieder']")
    public WebElement changeCardMember;

    @FindBy(xpath = "//input[@placeholder='Nach Benutzern suchen']")
    public WebElement inputSearchMember;

    @FindBy(xpath= "//a[@class='name js-select-member']")
    public WebElement addMember;

    @FindBy(xpath ="//div[@class='card-detail-item u-clearfix js-card-detail-members']")
    public List<WebElement> membersOnCard;

    @FindBy(xpath = "//div[@class='member js-member-on-card-menu']")
    public WebElement memberOnCardMenu;

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
