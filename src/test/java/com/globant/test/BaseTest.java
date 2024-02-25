package com.globant.test;

import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    WebDriver driver = null;
    SoftAssert softAssert = null;

    @BeforeClass
    static void setup(){
        WebDriverManager.chromedriver().setup();
    }

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
}
