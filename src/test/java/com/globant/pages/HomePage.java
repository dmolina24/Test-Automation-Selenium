package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id="searchInput")
    private WebElement searchInput;

    @FindBy(css="button[type=\"submit\"]")
    private WebElement submitBtn;

    @FindBy(className="central-featured-lang")
    private List<WebElement> langList;

    @FindBy(css=".footer-sidebar-text + div.footer-sidebar-text")
    private WebElement footerText;

    public void setBarText(String text){
        this.searchInput.sendKeys(text);
    }

    public SearchResult clickOnSearch(){
        this.submitBtn.click();
        return new SearchResult(driver);
    }

    public String getFooterText(){
        this.isElementDisplayed(this.footerText);
        return this.footerText.getText();
    }

    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }
}