package com.globant.data;
import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "uiElements")
    public static Object[][] uiElements() {
        return new Object[][] {
                {"Swag Labs", "Username", "Password", "Login" },
        };
    }

    @DataProvider(name = "validUsers")
    public static Object[][] validUsers() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "Products"}
        };
    }

    @DataProvider(name = "invalidUsers")
    public static Object[][] invalidUsers(){
        return new Object[][] {
                {"WrongUser", "IncorrectPassword", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
