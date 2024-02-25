package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(className = "login_logo")
    private WebElement loginTitle;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    @FindBy(css = "h3[data-test=\"error\"]")
    private WebElement errorMessage;

    public boolean isTitleLoginCorrect(String expectedTitle){
        this.isElementDisplayed(this.loginTitle);
        return this.loginTitle.getText().equals(expectedTitle);
    }

    public boolean isLoginBtnTextCorrect(String expectedText){
        this.isElementDisplayed(this.loginBtn);
        return this.loginBtn.getAttribute("value").equals(expectedText);
    }

    public boolean isPlaceHolderUsernameCorrect(String expectedValue){
        this.isElementDisplayed(this.userNameInput);
        return this.userNameInput.getAttribute("placeholder").equals(expectedValue);
    }

    public boolean isPlaceHolderPasswordCorrect(String expectedValue){
        this.isElementDisplayed(this.passwordInput);
        return this.passwordInput.getAttribute("placeholder").equals(expectedValue);
    }

    public String getErrorMessage(){
        this.isElementDisplayed(this.errorMessage);
        return this.errorMessage.getText();
    }

    public void setUserNameInput(String userName){
        this.userNameInput.sendKeys(userName);
    }

    public void setPasswordInput(String password){
        this.passwordInput.sendKeys(password);
    }

    public LoginPage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }
}
