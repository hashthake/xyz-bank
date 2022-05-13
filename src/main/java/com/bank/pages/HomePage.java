package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginTab;
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerloginTab;
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homePageTab;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnCustomerLoginTab(){
        Reporter.log("Click on CustomerLoginTab" + customerLoginTab.toString());
        clickOnElement(customerLoginTab);
    }
    public void clickOnManagerLoginTab(){
        Reporter.log("Click on BankmangerLoginTab" + "<br>");
        clickOnElement(bankManagerloginTab);
    }
    public void clickOnHomePageTab(){
        Reporter.log("Click on Homepage Tab" + "<br>");
        clickOnElement(homePageTab);
    }

}
