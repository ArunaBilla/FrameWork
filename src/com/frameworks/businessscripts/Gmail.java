package com.frameworks.businessscripts;


import org.testng.annotations.Test;

import com.frameworks.basetest.BaseEngine;

public class Gmail extends BaseEngine{
@Test
public void gm() {
getDriver().get("https://accounts.google.com");
getDriver().findElementById("identifierId1").sendKeys("aruna.k238");
}
}
