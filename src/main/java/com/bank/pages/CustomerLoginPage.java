package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {


    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectYourNameTab;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickOnLoginTab;

    public CustomerLoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void selectNameFromDropDown(String yourName){
        Reporter.log("Select Your Name" + selectYourNameTab.toString()+ "<br>");
        selectByVisibleTextFromDropDown(selectYourNameTab, yourName);
    }
    public void clickOnLoginTabBtn(){
        Reporter.log("Click on Login Tab" + "<br>");
        clickOnElement(clickOnLoginTab);
    }
}
