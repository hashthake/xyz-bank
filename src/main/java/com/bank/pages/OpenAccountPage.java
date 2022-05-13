package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchText;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyText;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processButton;

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    AddCustomerPage addCustomerPage = new AddCustomerPage();



    public void searchCustomer(String customerName){
        Reporter.log("Searching customer under open account page"+"\n</br>");
        selectByVisibleTextFromDropDown(searchText,customerName);
    }

    public void selectCurrency(String currency){
        Reporter.log("Select currency"+"\n</br>");
        selectByVisibleTextFromDropDown(currencyText,currency);
    }

    public void clickOnProcessButton(){
        Reporter.log("Clicking on Process button"+"\n</br>");
        clickOnElement(processButton);
    }

    public void verifyAccountCreatedSuccessfullyText(){
        Reporter.log("Clicking on Process button"+"\n</br>");

        String expected = "Account created successfully with account Number :1016";
        String actual = getTextFromAlert();
        Assert.assertEquals(expected.substring(0,20),actual.substring(0,20),"wrong message");
    }

    public void clickOnOkButtonPopUp(){
        acceptAlert();
    }
}
