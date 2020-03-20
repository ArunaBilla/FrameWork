package com.frameworks.businessscripts;

import org.testng.annotations.Test;

import com.frameworks.basetest.BaseEngine;

public class FB extends BaseEngine{
@Test	
public void fb() {
getDriver().get("https://www.facebook.com");
}
}
