package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(className = "app_logo")
    protected WebElement title;

    @FindBy(className = "shopping_cart_link")
    protected WebElement shoppingCart;

    @FindBy(id = "react-burger-menu-btn")
    protected WebElement burgerMenu;

    @FindBy(className = "title")
    protected WebElement subTitle;

    @FindBy(id =  "inventory_sidebar_link")
    protected WebElement linkAllItems;

    @FindBy(id= "about_sidebar_link")
    protected WebElement linkAbout;

    @FindBy(id="logout_sidebar_link")
    protected WebElement linkLogout;

    @FindBy(id = "logout_sidebar_link")
    protected WebElement linkReset;

    public String getTitle(){
        isElementDisplayed(title);
        return title.getText();
    }

    public String getSubTitle(){
        isElementDisplayed(subTitle);
        return subTitle.getText();
    }

    public String getTextLinkAllItems(){
        isElementDisplayed(linkAllItems);
        return linkAllItems.getText();
    }

    public String getTextLinkAbout(){
        isElementDisplayed(linkAbout);
        return linkAbout.getText();
    }

    public String getTextLinkLogout(){
        isElementDisplayed(linkLogout);
        return linkLogout.getText();
    }
    public void clickOnLogoutLink(){
        isElementDisplayed(this.linkLogout);
        this.linkLogout.click();
    }

    public void clickOnBurgerMenu(){
        isElementDisplayed(this.burgerMenu);
        this.burgerMenu.click();
    }

    public boolean isCartDisplayed(){
        isElementDisplayed(this.shoppingCart);
        return this.shoppingCart.isDisplayed();
    }

    public boolean isBurgerMenuDisplayed(){
        isElementDisplayed(this.burgerMenu);
        return this.burgerMenu.isDisplayed();
    }

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
}
