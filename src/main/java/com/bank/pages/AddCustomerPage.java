package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement enterFirstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement enterLastNameField;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement enterPotCodeField;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement addCustomerBtn;

    public AddCustomerPage(){
        PageFactory.initElements(driver,this);
    }

    public void enterFirstName(String firstNme){
        Reporter.log("Enter First name" + enterFirstNameField.toString()+ "<br");
        sendTextToElement(enterFirstNameField,firstNme);
    }
    public void enterLastName(String lastName){
        Reporter.log("Enter Last Name" + enterLastNameField.toString() + "<br>");
        sendTextToElement(enterLastNameField,lastName);
    }
    public void enterPostCode(String postCode){
        Reporter.log("Enter postcode" + enterPotCodeField.toString() + "<br>");
        sendTextToElement(enterPotCodeField,postCode);
    }
    public void clickOnAddCustomerBtn(){
        Reporter.log("Enter Add Customer Button" + "<br>");
        clickOnElement(addCustomerBtn);
    }

    public void verifyPopUpMessage(){

        String actual = getTextFromAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals(actual.substring(0,20),expected.substring(0,20),"wrong popup message");
    }

    public void clickOnOkButtonOnPopUp(){
        Reporter.log("Accepting popup message"+"\n</br>");
        acceptAlert();
    }
}
