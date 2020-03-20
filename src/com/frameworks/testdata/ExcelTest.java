package com.frameworks.testdata;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import com.frameworks.supporters.ExcelReader;

public class ExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelReader ex=new ExcelReader("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\testdata\\Text Data.xlsx");

	
	String celldata=ex.getSingleCellData("Sheet2", 0, 0);
	System.out.println("data in row0 cell0 is:"+celldata );
	int count=ex.findWord1("Sheet2", "aruna");
	}

}
