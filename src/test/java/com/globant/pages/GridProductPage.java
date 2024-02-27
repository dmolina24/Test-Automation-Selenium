package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class GridProductPage  extends BasePage{

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id="logout_sidebar_link")
    private WebElement linkLogout;

    public boolean isProductTitleCorrect(String expectedTitle){
        isElementDisplayed(this.title);
        return this.title.getText().equals(expectedTitle);
    }

    public WebElement selectRandomProduct() {
        Random random = new Random();
        int index = random.nextInt(productList.size());
        return productList.get(index);
    }

    public void addProductToCart(int numberOfProducts){
        if(numberOfProducts <= productList.size()){
            for(int i=0; i<numberOfProducts; i++){
                productList.get(i).findElement(By.className("btn_inventory")).click();
            }
        }

    }

    public CartPage clickOnCart(){
        isElementDisplayed(this.shoppingCart);
        this.shoppingCart.click();
        return new CartPage(driver);
    }

    public void clickOnBurgerMenu(){
        isElementDisplayed(this.burgerMenu);
        this.burgerMenu.click();
    }

    public void clickOnLogoutLink(){
        isElementDisplayed(this.linkLogout);
        this.linkLogout.click();
    }

    public void addRandomProductToCart() {
        WebElement randomProduct = selectRandomProduct();
        WebElement addToCartButton = randomProduct.findElement(By.className("btn_inventory"));
        addToCartButton.click();
    }

    public GridProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
