package com.globant.test;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test(groups = {"logout"})
    public void validateLogout(){
        gridProductPage.clickOnBurgerMenu();
        gridProductPage.clickOnLogoutLink();

        softAssert.assertTrue(loginPage.isLoginBtnTextCorrect("Login"));
        softAssert.assertTrue(loginPage.isTitleLoginCorrect("Swag Labs"));

        softAssert.assertAll();
    }
}
