package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends BasePage{
    public SearchResult(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "firstHeading")
    private WebElement title;

    public String getTextTitle(){
        isElementDisplayed(this.title);
        return this.title.getText();
    }
}
