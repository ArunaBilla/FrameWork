package com.frameworks.supporters;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.frameworks.utilities.RegExpUtility;

public class TxtRegExp {
	public static void main(String[] args) throws IOException {
		TextReader tr=new TextReader("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\supporters\\PhnNum.txt");
		tr.writeData("454545454545");
		tr.writeData("9703040008");
		tr.writeData("08886158612");
		tr.writeData("+919440220252");
		tr.writeData("4546534532763677");
	
		
	List<String> num=tr.getTotalFileData();

		for (String string : num) {
			RegExpUtility.isValidPhNum(string);
		}

	}

}