package com.trello.pages;

import com.trello.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage {
    public DashBoardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".board-tile-fade")
    public WebElement singleBoard;

    //@FindBy(xpath = "//input[@data-test-id='search-dialog-input']")



    @FindBy(css = "input[placeholder='Suchen']")
    public WebElement searchBox;

    @FindBy(css= "a[data-testid='cross-product-search-result']")
    public List<WebElement> searchResults;

    @FindBy(css = "a[data-testid='advanced-search-board-result-item']")
    public List<WebElement> advancedSearchBoardResult;

    @FindBy(xpath = "//span[normalize-space()='Alle Ergebnisse anzeigen']")
    public WebElement showAllResultsLink;

    @FindBy(xpath = "//li[@class='boards-page-board-section-list-item']")
    public List<WebElement> boardsList;

    @FindBy(xpath = "//a[@class='oTmCsFlPhDLGz2 AQ0dAIzWIJDFUU OV37mufLYcrSxq RPa_ezCLkUNX1W RdqZOPHqhCnasP']")
    public  WebElement boardsLink;

    @FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/div[2]/div/div/div[1]/div/div[3]/div[1]/div/ul/li[2]/a/div/div[1]")
    public WebElement NewBoard;


}
