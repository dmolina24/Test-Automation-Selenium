package com.globant.test;
import com.globant.data.LoginData;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeMethod(groups = "login")
    protected void getUrlSite(ITestContext context){
        String urlSite = context.getCurrentXmlTest().getParameter("urlSite");
        loginPage = getLoginPage(urlSite);
    }

    @Test(
            description="Validate login page UI text elements.",
            dataProviderClass = LoginData.class,
            dataProvider = "uiElements",
            groups = {"login"}
    )
    public void loginTextElementsTest(String expectedTitle, String placeHolderUserName, String placeHolderPass, String expectedTextButton){
        softAssert.assertTrue(loginPage.isTitleLoginCorrect(expectedTitle));
        softAssert.assertTrue(loginPage.isPlaceHolderUsernameCorrect(placeHolderUserName));
        softAssert.assertTrue(loginPage.isPlaceHolderPasswordCorrect(placeHolderPass));
        softAssert.assertTrue(loginPage.isLoginBtnTextCorrect(expectedTextButton));
        softAssert.assertAll();
    }

    @Test(description = "", dataProviderClass = LoginData.class, dataProvider = "validUsers", groups = {"login"})
    public void loginWithValidUserTest(String username, String password, String expectedTitle){

        loginPage.setUserNameInput(username);
        loginPage.setPasswordInput(password);

        gridProductPage = loginPage.clickLoginBtn();

        softAssert.assertTrue(gridProductPage.isProductTitleCorrect(expectedTitle));
        softAssert.assertAll();
    }

    @Test(description = "", dataProviderClass = LoginData.class, dataProvider = "invalidUsers", groups = {"login"})
    public void loginWithInValidUserTest(String username, String password, String expectedErrorMessage){

        loginPage.setUserNameInput(username);
        loginPage.setPasswordInput(password);
        loginPage.clickLoginBtn();

        softAssert.assertTrue(loginPage.isErrorMessageCorrect(expectedErrorMessage));
        softAssert.assertAll();
    }
}
