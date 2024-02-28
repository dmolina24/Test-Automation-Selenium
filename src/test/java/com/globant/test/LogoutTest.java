package com.globant.test;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test(groups = {"logout"})
    public void validateLogout(){

        softAssert.assertEquals(gridProductPage.getTitle(), "Swag Labs");
        softAssert.assertEquals(gridProductPage.getSubTitle(), "Products");
        softAssert.assertTrue(gridProductPage.isBurgerMenuDisplayed());

        gridProductPage.clickOnBurgerMenu();

        softAssert.assertEquals(gridProductPage.getTextLinkAllItems(), "All Items");
        softAssert.assertEquals(gridProductPage.getTextLinkAbout(), "About");
        softAssert.assertEquals(gridProductPage.getTextLinkLogout(), "Logout");

        gridProductPage.clickOnLogoutLink();

        softAssert.assertTrue(loginPage.isLoginBtnTextCorrect("Login"));
        softAssert.assertTrue(loginPage.isTitleLoginCorrect("Swag Labs"));

        softAssert.assertAll();
    }
}
