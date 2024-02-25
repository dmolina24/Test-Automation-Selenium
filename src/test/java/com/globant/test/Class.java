package com.globant.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Class {
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
    public void Form(){
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.click();
        firstName.sendKeys("Hello World");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.click();
        lastName.sendKeys("LastName");

        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();
    }
}
