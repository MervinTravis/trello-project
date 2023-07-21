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

    @FindBy(xpath = "//li[@class='boards-page-board-section-list-item']")
    public List<WebElement> boardsList;

}
