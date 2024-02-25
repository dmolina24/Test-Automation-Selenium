package com.globant.test;

import com.globant.pages.HomePage;
import com.globant.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    HomePage homePage;
    WebDriver driver = null;
    SoftAssert softAssert = null;

    @BeforeTest
    public void beforeText(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @AfterTest
    void tearDown(){
        //driver.quit();
        driver.close();
    }


    public LoginPage getLoginPage(String urlWebSite){
        return new LoginPage(driver, urlWebSite);
    }

    public HomePage getHomePage(){
        return new HomePage(driver,"https://www.saucedemo.com/");
    }
}
