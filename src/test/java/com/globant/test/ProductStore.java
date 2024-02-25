package com.globant.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductStore {
    WebDriver driver = null;
    WebDriverWait wait = null;

    @BeforeClass
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    void tearDown() {
        //driver.quit();
    }

    @Test
    public void SignUp(){
        driver.navigate().to("https://demoblaze.com/");

        WebElement signBtn = driver.findElement(By.id("signin2"));
        signBtn.click();

        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        userName.sendKeys("pedropicapiedra4090" );

        WebElement userPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
        userPass.sendKeys("1234");

        WebElement signUpBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[onClick=\"register()\"]")));
        signUpBtn.click();
    }

}
