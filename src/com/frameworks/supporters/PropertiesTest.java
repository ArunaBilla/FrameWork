package com.frameworks.supporters;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		PropertiesReader pr=new PropertiesReader("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\objectRepository\\OR_Gmail.properties");
		Set<String> keys=pr.getAllKeys();
		System.out.println("keys are:"+keys);
		List<String> values=pr.getAllValues();
		System.out.println("values are:"+values);
		Map<String, String> keysvalues=pr.getAllKeyValues();
		System.out.println("keys and values:"+keysvalues);
	}

}
