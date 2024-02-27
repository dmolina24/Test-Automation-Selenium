package com.globant.test;

import com.globant.pages.CartPage;
import com.globant.pages.CheckOut.CheckOutInformationPage;
import com.globant.pages.CheckOut.CheckOutOverviewPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(groups = {"purchase-product"}, dependsOnGroups = {"login"})
    public void purchaseProduct() {

        gridProductPage.addRandomProductToCart();
        CartPage cartPage = gridProductPage.clickOnCart();

        softAssert.assertEquals(cartPage.getSubTitle(),"Your Cart");
        softAssert.assertEquals(cartPage.getQuantityLabel(), "QTY" );
        softAssert.assertEquals(cartPage.getDescLabel(), "Description");

        CheckOutInformationPage checkOutInfoPage = cartPage.clickCheckOutBtn();

        softAssert.assertEquals(checkOutInfoPage.getTitle(), "Checkout: Your Information");

        checkOutInfoPage.setFirstName("Generic Name");
        checkOutInfoPage.setLastNameInput("Generic Last Name");
        checkOutInfoPage.setPostalCodeInput("Generic Code");

        CheckOutOverviewPage checkOutOverviewPage= checkOutInfoPage.clickContinueBtn();

        checkOutOverviewPage.printText();
        checkOutOverviewPage.clickFinishBtn();

        softAssert.assertAll();
    }

    @Test(groups = {"remove-elements"}, dependsOnGroups = {"login"})
    public void removeElementShoppingCart(){

        gridProductPage.addProductToCart(3);
        CartPage cartPage = gridProductPage.clickOnCart();

        softAssert.assertEquals(cartPage.getSizeCartList(), 3);
        cartPage.emptyCart();
        softAssert.assertEquals(cartPage.getSizeCartList(), 0);

        softAssert.assertAll();
    }

}
