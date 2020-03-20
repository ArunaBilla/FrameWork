package com.frameworks.utilities;

import com.frameworks.basetest.BaseEngine;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsTest extends BaseEngine{
	
	public static void main(String[] args) {
		//getDriver().get("https://accounts.google.com");
		//beforetest
		ExtentReports extentReports=new ExtentReports("E:\\JAVA SELENIUM\\FrameWorks1\\reports.html");
		//beforemethod
		ExtentTest extentTest=extentReports.startTest("plz practice");
		//testcaselevel
		extentTest.log(LogStatus.INFO, "Browser is opened");
		extentTest.log(LogStatus.INFO, "URL is entered:www.gmail.com");
		extentTest.log(LogStatus.INFO, "DTA is done on username with testdata: plz practice");
		//aftermethod
		extentReports.endTest(extentTest);
		extentReports.flush();
		//aftertest
		extentReports.close();
	}

}
