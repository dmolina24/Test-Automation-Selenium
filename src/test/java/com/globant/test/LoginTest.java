package com.globant.test;

import com.globant.data.LoginData;
import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeClass
    static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Parameters("urlWebSite")
    @Test(description="",dataProviderClass = LoginData.class, dataProvider = "uiElements")
    public void loginTextElementsTest(ITestContext context, String expectedTitle, String placeHolderUserName, String placeHolderPass, String expectedTextButton){
        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        LoginPage loginTest = getLoginPage(urlSite);
        softAssert.assertTrue(loginTest.isTitleLoginCorrect(expectedTitle));
        softAssert.assertTrue(loginTest.isPlaceHolderUsernameCorrect(placeHolderUserName));
        softAssert.assertTrue(loginTest.isPlaceHolderPasswordCorrect(placeHolderPass));
        softAssert.assertTrue(loginTest.isLoginBtnTextCorrect(expectedTextButton));
        softAssert.assertAll();
    }

    @Test(description = "", dataProviderClass = LoginData.class, dataProvider = "validUsers")
    public void loginWithValidUserTest(ITestContext context, String username, String password){
        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        LoginPage loginTest = getLoginPage(urlSite);
        loginTest.setUserNameInput(username);
        loginTest.setPasswordInput(password);
    }

    @Test(description = "", dataProviderClass = LoginData.class, dataProvider = "invalidUsers" )
    public void loginWithInValidUserTest(ITestContext context, String username, String password){
        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        LoginPage loginPage = getLoginPage(urlSite);
        loginPage.setUserNameInput(username);
        loginPage.setPasswordInput(password);
    }
}
