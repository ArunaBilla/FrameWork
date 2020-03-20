package com.frameworks.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fip=new FileInputStream("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\supporters\\Text Data.xlsx");
		Workbook workbook=WorkbookFactory.create(fip);
Sheet sheet=workbook.getSheet("Sheet2");
Cell cell=sheet.getRow(2).getCell(0);
String cellvalue=cell.getStringCellValue();
System.out.println("cellvalue is:"+cellvalue);
	}

}
