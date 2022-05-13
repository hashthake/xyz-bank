package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CustomerPage extends Utility {

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOutBtn;
    @FindBy(xpath = "//strong//span[@class='fontBig ng-binding']")
    WebElement nameText;

    public CustomerPage(){
        PageFactory.initElements(driver,this);
    }
    public void logOutBtnIsDisplay(){
        waitUntilVisibilityOfElementLocated(By.xpath("//strong//span[@class='fontBig ng-binding']"),20);
        boolean actual = logOutBtn.isDisplayed();
        Assert.assertTrue(actual);
    }
    public String verifyNameIsOnDisplay(){
        Reporter.log("Verify Name is on display" + "<br>");
        return getTextFromElement(nameText);
    }
    public void clickOnLogOutButton(){
        Reporter.log("Click on LogOut Button" + "<br>");
        clickOnElement(logOutBtn);
    }
}
