package com.globant.pages.CheckOut;

import com.globant.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage extends BasePage {

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(css = ".summary_info_label:nth-of-type(1)")
    private WebElement paymentInfoLabel;

    @FindBy(css = ".summary_info_label:nth-of-type(1)")
    private WebElement priceTotalLabel;

    @FindBy(css = ".summary_info_label:nth-of-type(1)")
    private WebElement shippingInfo;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public void clickFinishBtn(){
        isElementDisplayed(this.finishBtn);
        this.finishBtn.click();
    }

    public void printText(){
        System.out.println("paymentInfoLabel: "+  paymentInfoLabel.getText());
        System.out.println(priceTotalLabel.getText());
        System.out.println(shippingInfo.getText());
    }

    public CheckOutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
