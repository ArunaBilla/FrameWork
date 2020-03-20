package com.frameworks.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.frameworks.basetest.BaseEngine;

public class GmailHomePage extends BaseEngine{
@FindBy(id="identifierId")
public static WebElement UserName;

@FindBy(xpath="//button[contains(text(),'Forgot email?')]")
public static WebElement ForgotPswd;

@FindBy(xpath="//span[contains(text(),'Create account')]")
public static WebElement CreateAccount;

@FindBy(id="identifierNext")
public static WebElement Next;

@FindBy(linkText="Learn more")
public static WebElement LearnMore;

public static void userName(String name) {
UserName.sendKeys(name);
}
public static void forgotPswd() {
	ForgotPswd.click();
}
public static void createAccount() {
CreateAccount.click();
}
public static void next() {
Next.click();
}
}
