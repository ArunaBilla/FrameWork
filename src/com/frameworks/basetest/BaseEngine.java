package com.frameworks.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.frameworks.appconstants.Constants;
import com.frameworks.utilities.ScreenShotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseEngine {
	private static RemoteWebDriver driver;
	private static String curDir;
	private static String tcName;
	private static ExtentReports extentReports;
	private static ExtentTest extenttest;

	@Parameters("browser")
	@BeforeSuite
	public void openBrowser(@Optional("chrome") String browser) {
		curDir = System.getProperty("user.dir");
		System.out.println("cur userdir is:" + curDir);
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", curDir + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			init();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", curDir + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			init();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", curDir + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			init();
		}

	}

	private void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeTcExecution(Method method) {
		tcName = method.getName();
		System.out.println("current executing tc is:" + tcName);
		extenttest = extentReports.startTest(tcName);
	}

	@AfterMethod
	public void afterTcExection(ITestResult result) throws IOException {
		tcName = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("tc is passed" + tcName);
			extenttest.log(LogStatus.PASS, "TC is passed" + tcName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			/*
			 * File img = driver.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(img,
			 * new File(curDir + "\\ScreenShots\\" + tcName + ".jpeg"));
			 */
			String imagePath = ScreenShotUtility.screenShot();
			System.out.println("tc is failed so taking screenshot:" + tcName);
			extenttest.log(LogStatus.FAIL, "TC is failed" + tcName);
			extenttest.log(LogStatus.FAIL, result.getThrowable());
			extenttest.addScreenCapture(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			File img = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(img, new File(curDir + "\\ScreenShots\\" + tcName + ".jpeg"));
			String imagePath = ScreenShotUtility.screenShot();
			System.out.println("tc is skipped so taking screenshot:" + tcName);
			extenttest.log(LogStatus.SKIP, "TC is skipped" + tcName);
		}
		System.out.println("TC execution is ended" + tcName);
		extentReports.endTest(extenttest);
		extentReports.flush();
	}

	public static String getCurDir() {
		return curDir;
	}

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	public static String getTcName() {
		return tcName;
	}

	@AfterSuite
	public void closeBrowser() {
		if (driver != null)
			driver.close();
		else
			System.out.println("driver is pointing to null");
	}

	@BeforeTest
	public void reportInit() {

		extentReports = new ExtentReports("E:\\JAVA SELENIUM\\FrameWorks1\\reports\\gmail.html");
	}

	@AfterTest
	public void endReport() {
		extentReports.close();
	}

}