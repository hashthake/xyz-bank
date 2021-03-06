package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;

    @FindBy(xpath = "//span[contains(normalize-space(),'Deposit Successful')]")
    WebElement depositMessage;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawlTab;

    @FindBy(xpath = "(//input[@placeholder='amount'])[1]")
    WebElement withdrawlAmountField;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawlButton;

    @FindBy(xpath = "//span[contains(normalize-space(),'Transaction successful')]")
    WebElement withdrawlMessage;

    public AccountPage() {

        PageFactory.initElements(driver, this);
    }

    public void clickOnDepositTab() {
        Reporter.log("Clicking on deposit tab " + depositTab.toString() + "\n</br>");
        clickOnElement(depositTab);
    }

    public void enterAmount(String amount) {
        Reporter.log("entering amount" + amountField.toString() + "\n</br>");
        sendTextToElement(amountField, amount);
    }

    public void clickOnDepositButton() {
        Reporter.log("Clicking on deposit button" + depositButton.toString() + "\n</br>");
       clickOnElement(depositButton);
    }
    public String verifyDepositSuccessfulMessage(){
        Reporter.log("Verify Deposit successful Message" + depositMessage.toString()+ "<br>");
        return getTextFromElement(depositMessage);
    }
    public void clickOnWithdrawlTab() {
        Reporter.log("Clicking on withdrawl tab" + withdrawlTab.toString() + "\n</br>");
        clickOnElement(withdrawlTab);

    }

    public void enterWithdrawlAmount(String amount) {
        Reporter.log("Entering withdrawl amount" + withdrawlAmountField.toString() + "\n</br>");
        //waitForElementWithFluentWait(By.xpath("(//input[@placeholder='amount'])[1]"),100,5);
        sendTextToElement(withdrawlAmountField, amount);

    }

    public void clickOnWithdrawlButton() {
        Reporter.log("Clicking on withdrawl button" + withdrawlButton.toString() + "\n</br>");
        //pmWaitUntilVisibilityOfElementLocated(By.xpath("//button[normalize-space()='Withdraw']"),100);
        clickOnElement(withdrawlButton);
    }
    public String verifytransactionSuccessfulMessage(){
        Reporter.log("Verify withdrawl message" + withdrawlMessage.toString()+ "<br>");
        return getTextFromElement(withdrawlMessage);
    }

}
