package com.frameworks.pageobjectmodel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FacebookHomePage {
@FindBy(id="email")
public static WebElement UserName;

@FindBy(id="pass")
public static WebElement pwd;

@FindBy(id="u_0_b")
public static WebElement LogIn;

@FindBy(name="firstname")
public static WebElement FirstName;

@FindBy(name="lastname")
public static WebElement LastName;

@FindBy(name="reg_email__")
public static WebElement MobileNum;

@FindBy(name="reg_passwd__")
public static WebElement NewPwd;

@FindBy(id="day")
public static WebElement Date;

@FindBy(id="month")
public static WebElement Month;

@FindBy(id="year")
public static WebElement Year;

@FindBy(xpath="//*[contains(text(),'Female')]")
public static WebElement Female;

@FindBy(xpath="//*[contains(text(),'Male')]")
public static WebElement Male;

@FindBy(xpath="//*[contains(text(),'Custom')]")
public static WebElement Custom;

@FindBy(xpath="//*[contains(text(),'Sign Up')]")
public static WebElement SignUp;

public static void username(String name) {
UserName.sendKeys(name);
}
public static void pwd(String name) {
pwd.sendKeys(name);
}
public static void logIn() {
LogIn.click();
}
public static void firstName(String name) {
FirstName.sendKeys(name);
}
public static void surName(String name) {
 LastName.sendKeys(name);
}
public static void mobileNum(String name) {
MobileNum.sendKeys(name);
}
public static void newPwd(String name) {
NewPwd.sendKeys(name);
}
public static void date(String value) {
Select select = new Select(Date);
select.selectByValue(value);
}
 public static void month(String value) throws InterruptedException {
	
Select select=new Select(Month);
select.selectByVisibleText(value);
List<WebElement> list=select.getOptions();
List<WebElement> l= new ArrayList();
for(WebElement w:list)
{
w.click();
Thread.sleep(3000);
}

 }
 public static void year(String value) {
Select select=new Select(Year);
select.selectByValue(value);
}
 public static void female() {
if(Female.isDisplayed()&&Female.isEnabled()) 
	Female.click();
	else
		System.out.println("it is not visible");
}
 public static void male() {
if(Male.isDisplayed()&&Male.isEnabled()) 
	Male.click();
else
	System.out.println("it is not visible");
}
 public static void custom() {
if(Custom.isDisplayed()&&Custom.isEnabled())
	Custom.click();
else
	System.out.println("it is not visible");
}
public static void signUp() {
SignUp.click();
}


}
