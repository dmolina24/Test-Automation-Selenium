package com.globant.pages.CheckOut;

import com.globant.pages.BasePage;
import com.globant.pages.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends HeaderPage {

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(className = "pony_express")
    private WebElement iconCheck;

    @FindBy(className = "complete-header")
    private WebElement completeTitle;

    @FindBy(className = "complete-text")
    private WebElement completeText;

    @FindBy(id = "#back-to-products")
    private WebElement backHomeBtn;

    public CheckOutCompletePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
