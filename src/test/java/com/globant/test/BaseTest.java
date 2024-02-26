package com.globant.test;

import com.globant.pages.GridProductPage;
import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver = null;
    protected SoftAssert softAssert = null;

    static LoginPage loginPage;
    static GridProductPage gridProductPage;

    @BeforeClass
    static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeGroups("login")
    public void initDriver(){
        driver = new ChromeDriver();
    }

    @BeforeMethod(groups = {"login", "purchase-product"})
    public void initAssert(){
        softAssert = new SoftAssert();
    }

    @AfterTest
    void tearDown(){
        //driver.quit();
        driver.close();
    }

    @AfterGroups(groups = {"purchase-product"})
    void closeDriver(){
        driver.quit();
    }

    public LoginPage getLoginPage(String urlWebSite){
        return new LoginPage(driver, urlWebSite);
    }
}
