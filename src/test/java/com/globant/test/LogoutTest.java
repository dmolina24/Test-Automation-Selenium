package com.globant.test;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test(groups = {"logout"})
    public void validateLogout(){
        gridProductPage.clickOnBurgerMenu();
        gridProductPage.clickOnLogoutLink();
        softAssert.assertAll();
    }
}
