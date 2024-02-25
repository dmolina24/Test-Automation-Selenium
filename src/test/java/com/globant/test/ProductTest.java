package com.globant.test;

import com.globant.pages.CartPage;
import com.globant.pages.CheckOutPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(groups = {"purchase-product"}, dependsOnGroups = {"login"})
    public void purchaseProduct() {

        gridProductPage.addRandomProductToCart();
        CartPage cartPage = gridProductPage.clickOnCart();

        softAssert.assertEquals(cartPage.getTitle(),"Your Cart");
        softAssert.assertEquals(cartPage.getQuantityLabel(), "QTY" );
        softAssert.assertEquals(cartPage.getDescLabel(), "Description");

        CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();

        softAssert.assertEquals(checkOutPage.getTitle(), "Checkout: Your Information");

        checkOutPage.setFirstName("Generic Name");
        checkOutPage.setLastNameInput("Generic Last Name");
        checkOutPage.setPostalCodeInput("Generic Code");

        checkOutPage.clickContinueBtn();

        softAssert.assertAll();
    }

    @Test(groups = {"remove-elements"}, dependsOnGroups = {"login"})
    public void removeElementShoppingCart(){
        System.out.println("Purchase Test - 2");
    }

}
