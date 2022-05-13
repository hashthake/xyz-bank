package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomerTab;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement openAccountTab;

    public BankManagerLoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnAddCustomerTab(){
        Reporter.log("Click on AddCustomerTab" + addCustomerTab.toString() + "<br>");
        clickOnElement(addCustomerTab);
    }
    public void clickOnOpenAccountTab(){
        Reporter.log("Click on OpenAccountTan" + openAccountTab.toString() + "<br>");
        clickOnElement(openAccountTab);
    }


}
