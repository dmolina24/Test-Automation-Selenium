package com.globant.test;

import com.globant.pages.HomePage;
import com.globant.pages.SearchResult;
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
import java.util.List;

public class FirstTest extends BaseTest {


    @BeforeClass
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
    }



    /*@BeforeTest
    void setup(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }*/



    @Test
    public void testWikiFactoryPage(){
        HomePage homePage = getHomePage();
        homePage.setBarText("Selenium");
        softAssert.assertEquals(homePage.getFooterText(), "You can support our work with a donation.");

        SearchResult searchResult = homePage.clickOnSearch();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        softAssert.assertEquals(searchResult.getTextTitle(), "Selenium");
        softAssert.assertAll();

    }

    @Test
    public void testWiki(){
        driver.navigate().to("https://wikipedia.org");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        WebElement footerLink = driver.findElement(By.cssSelector(".footer-sidebar-text + div.footer-sidebar-text"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=\"submit\"]"));

        searchInput.sendKeys("Selenium");

        softAssert.assertEquals(footerLink.getText(), "You can support our work with a donation.");
        softAssert.assertTrue(submitBtn.isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> langList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("central-featured-lang")));

        softAssert.assertEquals(langList.size(), 10);
        submitBtn.click();

        softAssert.assertAll();
    }
}
