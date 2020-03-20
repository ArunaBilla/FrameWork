package com.frameworks.pageobjectmodel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.frameworks.basetest.BaseEngine;

public class FbPOM extends BaseEngine{
	@Test
public static void fb() throws InterruptedException {
getDriver().get("https://www.facebook.com");
	PageFactory.initElements(getDriver(), FacebookHomePage.class);
	FacebookHomePage.firstName("aruna");
	FacebookHomePage.surName("k");
	FacebookHomePage.mobileNum("9703040005");
	FacebookHomePage.newPwd("arunaraju");
	FacebookHomePage.date("23");
	FacebookHomePage.month("Aug");
	FacebookHomePage.year("1992");
	FacebookHomePage.female();
	FacebookHomePage.male();
	FacebookHomePage.custom();
}
}
