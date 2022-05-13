package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import javafx.scene.Group;
import javafx.scene.control.Tab;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomerPage customerPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    @BeforeMethod
    public void init(){
        accountPage = new AccountPage();
        addCustomerPage= new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customerPage = new CustomerPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }
    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully(){
        homePage.clickOnManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName("Ron");
        addCustomerPage.enterLastName("Weasly");
        addCustomerPage.enterPostCode("cv11vc");
        addCustomerPage.clickOnAddCustomerBtn();
        addCustomerPage.verifyPopUpMessage();
        addCustomerPage.clickOnOkButtonOnPopUp();
    }
    @Test(groups = {"sanity","regression","smoke"})
    public void bankManagerShouldOpenAccountSuccesfully(){
        homePage.clickOnManagerLoginTab();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.searchCustomer("Ron Weasly");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.verifyAccountCreatedSuccessfullyText();
        openAccountPage.clickOnOkButtonPopUp();
    }
    @Test(groups = {"smoke","regression"})
    public void customerShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.selectNameFromDropDown("Ron Weasly");
        customerLoginPage.clickOnLoginTabBtn();
        customerPage.logOutBtnIsDisplay();
        String expectedText = "Ron Weasly";
        String actualText = customerPage.verifyNameIsOnDisplay();
        Assert.assertEquals(expectedText,actualText);
        customerPage.clickOnLogOutButton();
    }
    @Test(groups = {"smoke","regression"})
    public void customerShouldDepositMoneySuccessfully(){
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.selectNameFromDropDown("Ron Weasly");
        customerLoginPage.clickOnLoginTabBtn();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();
        String expectedText = "Deposit Successful";
        String actualText = accountPage.verifyDepositSuccessfulMessage();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.selectNameFromDropDown("Ron Weasly");
        customerLoginPage.clickOnLoginTabBtn();

        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();
        Thread.sleep(2000);

        accountPage.clickOnWithdrawlTab();
        Thread.sleep(2000);
        accountPage.enterWithdrawlAmount("50");
        Thread.sleep(2000);
        accountPage.clickOnWithdrawlButton();
        Thread.sleep(2000);
        String expectedText = "Transaction successful";
        String actualText = accountPage.verifytransactionSuccessfulMessage();
        Assert.assertEquals(expectedText,actualText);
    }

}
