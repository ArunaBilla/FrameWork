package com.frameworks.pageobjectmodel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.frameworks.basetest.BaseEngine;

public class GmailPOM extends BaseEngine{
@Test
public void gmail() {
getDriver().get("https://accounts.google.com");
PageFactory.initElements(getDriver(), GmailHomePage.class);
GmailHomePage.userName("aruna.k238");
GmailHomePage.createAccount();
}
}
