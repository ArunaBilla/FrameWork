package com.frameworks.listeners;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.frameworks.basetest.BaseEngine;
import com.frameworks.utilities.ScreenShotUtility;

public class ScreenShotAdapter extends TestListenerAdapter{

	@Override
	public void onTestFailure(ITestResult arg0) {
try {
	ScreenShotUtility.screenShot();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
System.out.println("TC IS FAILED SO TAKING SCREENSHOT:"+BaseEngine.getTcName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		try {
			ScreenShotUtility.screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TC IS FAILED SO TAKING SCREENSHOT:"+BaseEngine.getTcName());
	}
}
