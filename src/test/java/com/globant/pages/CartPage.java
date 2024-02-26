package com.globant.pages;

import com.globant.pages.CheckOut.CheckOutInformationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "cart_quantity_label")
    private WebElement cartQuantityLabel;

    @FindBy(className = "cart_desc_label")
    private WebElement cartDescriptionLabel;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public String getTitle(){
        isElementDisplayed(this.title);
        return this.title.getText();
    }

    public String getQuantityLabel(){
        isElementDisplayed(this.cartQuantityLabel);
        return this.cartQuantityLabel.getText();
    }

    public String getDescLabel(){
        isElementDisplayed(this.cartDescriptionLabel);
        return this.cartDescriptionLabel.getText();
    }

    public CheckOutInformationPage clickCheckOutBtn(){
        isElementDisplayed(this.checkoutBtn);
        this.checkoutBtn.click();
        return new CheckOutInformationPage(driver);
    }

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
