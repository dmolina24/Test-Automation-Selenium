package com.globant.pages.CheckOut;
import com.globant.pages.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage extends HeaderPage {

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(css = ".summary_info_label:nth-of-type(1)")
    private WebElement paymentInfoLabel;

    @FindBy(css = ".summary_info_label:nth-of-type(3)")
    private WebElement shippingInfo;

    @FindBy(css = ".summary_info_label:nth-of-type(5)")
    private WebElement priceTotalLabel;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public CheckOutCompletePage clickFinishBtn(){
        isElementDisplayed(this.finishBtn);
        this.finishBtn.click();

        return new CheckOutCompletePage(driver);
    }

    public String getTextPaymentInfoLabel(){
        isElementDisplayed(paymentInfoLabel);
        return paymentInfoLabel.getText();
    }

    public String getTextShippingInfo(){
        isElementDisplayed(shippingInfo);
        return shippingInfo.getText();
    }

    public String getTextPriceTotalLabel(){
        isElementDisplayed(priceTotalLabel);
        return priceTotalLabel.getText();
    }


    public CheckOutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
