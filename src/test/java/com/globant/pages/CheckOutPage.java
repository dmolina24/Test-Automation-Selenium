package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage{

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    public String getTitle(){
        isElementDisplayed(this.title);
        return this.title.getText();
    }

    public void setFirstName(String name){
        isElementDisplayed(this.firstNameInput);
        this.firstNameInput.sendKeys(name);
    }

    public void setLastNameInput(String lastName){
        isElementDisplayed(this.lastNameInput);
        this.lastNameInput.sendKeys(lastName);
    }

    public void setPostalCodeInput(String code){
        isElementDisplayed(this.postalCodeInput);
        this.postalCodeInput.sendKeys(code);
    }

    public void clickContinueBtn(){
        isElementDisplayed(this.continueBtn);
        this.continueBtn.click();
    }

    public CheckOutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
