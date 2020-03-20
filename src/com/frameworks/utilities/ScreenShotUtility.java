package com.frameworks.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.frameworks.basetest.BaseEngine;

public interface ScreenShotUtility {
public static String screenShot() throws IOException
{
	String imagePath = BaseEngine.getCurDir()+"\\Screenshots\\"+BaseEngine.getTcName()+".jpeg";
	File img = BaseEngine.getDriver().getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(img, new File(BaseEngine.getCurDir() + "\\ScreenShots\\" + BaseEngine.getTcName() + ".jpeg"));
	return imagePath;
}
}

