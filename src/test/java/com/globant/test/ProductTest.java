package com.globant.test;

import com.globant.pages.CartPage;
import com.globant.pages.CheckOut.CheckOutCompletePage;
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

        softAssert.assertEquals(checkOutInfoPage.getTitle(), "Swag Labs");
        softAssert.assertEquals(checkOutInfoPage.getSubTitle(), "Checkout: Your Information");
        softAssert.assertTrue(checkOutInfoPage.isCartDisplayed());
        softAssert.assertTrue(checkOutInfoPage.isBurgerMenuDisplayed());

        checkOutInfoPage.clickOnBurgerMenu();

        softAssert.assertEquals(checkOutInfoPage.getTextLinkAllItems(), "All Items");
        softAssert.assertEquals(checkOutInfoPage.getTextLinkAbout(), "About");
        softAssert.assertEquals(checkOutInfoPage.getTextLinkLogout(), "Logout");

        checkOutInfoPage.setFirstName("Generic Name");
        checkOutInfoPage.setLastNameInput("Generic Last Name");
        checkOutInfoPage.setPostalCodeInput("Generic Code");

        CheckOutOverviewPage checkOutOverviewPage= checkOutInfoPage.clickContinueBtn();

        softAssert.assertEquals(checkOutOverviewPage.getTitle(), "Swag Labs");
        softAssert.assertEquals(checkOutOverviewPage.getSubTitle(), "Checkout: Overview");
        softAssert.assertTrue(checkOutOverviewPage.isBurgerMenuDisplayed());
        softAssert.assertTrue(checkOutOverviewPage.isCartDisplayed());

        checkOutOverviewPage.clickOnBurgerMenu();

        softAssert.assertEquals(checkOutOverviewPage.getTextLinkAllItems(), "All Items");
        softAssert.assertEquals(checkOutOverviewPage.getTextLinkAbout(), "About");
        softAssert.assertEquals(checkOutOverviewPage.getTextLinkLogout(), "Logout");

        softAssert.assertEquals(checkOutOverviewPage.getTextPaymentInfoLabel(), "Payment Information");
        softAssert.assertEquals(checkOutOverviewPage.getTextShippingInfo(), "Shipping Information");
        softAssert.assertEquals(checkOutOverviewPage.getTextPriceTotalLabel(), "Price Total");

        CheckOutCompletePage checkOutCompletePage = checkOutOverviewPage.clickFinishBtn();

        softAssert.assertEquals(checkOutCompletePage.getTitle(), "Swag Labs");
        softAssert.assertEquals(checkOutCompletePage.getSubTitle(), "Checkout: Complete!");
        softAssert.assertTrue(checkOutCompletePage.isBurgerMenuDisplayed());
        softAssert.assertTrue(checkOutCompletePage.isCartDisplayed());

        checkOutCompletePage.clickOnBurgerMenu();

        softAssert.assertEquals(checkOutCompletePage.getTextLinkAllItems(), "All Items");
        softAssert.assertEquals(checkOutCompletePage.getTextLinkAbout(), "About");
        softAssert.assertEquals(checkOutCompletePage.getTextLinkLogout(), "Logout");

        softAssert.assertTrue(checkOutCompletePage.isIconCheckDisplayed());
        softAssert.assertEquals(checkOutCompletePage.getTextCompleteTitle(), "Thank you for your order!");
        softAssert.assertEquals(checkOutCompletePage.getTextCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        softAssert.assertAll();
    }

    @Test(groups = {"remove-elements"}, dependsOnGroups = {"login"})
    public void removeElementShoppingCart(){

        gridProductPage.addProductToCart(3);
        CartPage cartPage = gridProductPage.clickOnCart();

        softAssert.assertEquals(cartPage.getSizeCartList(), 3);
        cartPage.emptyCart();

        softAssert.assertEquals(cartPage.getSizeCartList(), 0);
        softAssert.assertEquals(cartPage.getTitle(), "Swag Labs");
        softAssert.assertEquals(cartPage.getSubTitle(), "Your Cart");
        softAssert.assertTrue(cartPage.isBurgerMenuDisplayed());

        cartPage.clickOnBurgerMenu();

        softAssert.assertEquals(cartPage.getTextLinkAllItems(), "All Items");
        softAssert.assertEquals(cartPage.getTextLinkAbout(), "About");
        softAssert.assertEquals(cartPage.getTextLinkLogout(), "Logout");

        softAssert.assertAll();
    }

}
