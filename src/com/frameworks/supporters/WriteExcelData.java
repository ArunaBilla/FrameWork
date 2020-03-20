package com.frameworks.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelData {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fip = new FileInputStream("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\supporters\\Text Data.xlsx");
	Workbook workbook=WorkbookFactory.create(fip);
	Sheet sheet=workbook.getSheet("java");
	Cell cell00=sheet.createRow(0).createCell(0);
	cell00.setCellValue("rameshsoft");
	FileOutputStream fop=new FileOutputStream("E:\\JAVA SELENIUM\\FrameWorks1\\src\\com\\frameworks\\supporters\\Text Data.xlsx");
	workbook.write(fop);
}
}
