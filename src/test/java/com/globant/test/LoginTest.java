package com.globant.test;

import com.globant.data.LoginData;
import com.globant.pages.GridProductPage;
import com.globant.pages.LoginPage;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(
            description="",
            dataProviderClass = LoginData.class,
            dataProvider = "uiElements",
            groups = {"login"}
    )
    public void loginTextElementsTest(ITestContext context, String expectedTitle, String placeHolderUserName, String placeHolderPass, String expectedTextButton){

        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        LoginPage loginPage = getLoginPage(urlSite);

        softAssert.assertTrue(loginPage.isTitleLoginCorrect(expectedTitle));
        softAssert.assertTrue(loginPage.isPlaceHolderUsernameCorrect(placeHolderUserName));
        softAssert.assertTrue(loginPage.isPlaceHolderPasswordCorrect(placeHolderPass));
        softAssert.assertTrue(loginPage.isLoginBtnTextCorrect(expectedTextButton));
        softAssert.assertAll();
    }

    @Test(description = "", dataProviderClass = LoginData.class, dataProvider = "validUsers", groups = {"login"})
    public void loginWithValidUserTest(ITestContext context, String username, String password, String expectedTitle){

        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        LoginPage loginPage = getLoginPage(urlSite);
        loginPage.setUserNameInput(username);
        loginPage.setPasswordInput(password);

        GridProductPage gridProductPage = loginPage.clickLoginBtn();
        softAssert.assertTrue(gridProductPage.isProductTitleCorrect(expectedTitle));
        softAssert.assertAll();
    }

    @Test(description = "", dataProviderClass = LoginData.class, dataProvider = "invalidUsers", groups = {"login"})
    public void loginWithInValidUserTest(ITestContext context, String username, String password, String expectedErrorMessage){

        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        LoginPage loginPage = getLoginPage(urlSite);

        loginPage.setUserNameInput(username);
        loginPage.setPasswordInput(password);
        loginPage.clickLoginBtn();

        softAssert.assertTrue(loginPage.isErrorMessageCorrect(expectedErrorMessage));
        softAssert.assertAll();
    }
}
