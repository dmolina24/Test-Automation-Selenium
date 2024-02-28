package com.globant.pages.CheckOut;

import com.globant.pages.BasePage;
import com.globant.pages.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInformationPage extends HeaderPage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

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

    public CheckOutOverviewPage clickContinueBtn(){
        isElementDisplayed(this.continueBtn);
        this.continueBtn.click();
        return new CheckOutOverviewPage(driver);
    }

    public CheckOutInformationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
