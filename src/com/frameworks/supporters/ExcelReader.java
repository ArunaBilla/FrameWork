package com.frameworks.supporters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.thoughtworks.selenium.webdriven.commands.GetLocation;

public class ExcelReader {
	private String FilePath;
	private File file;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String CellValue;

	public ExcelReader(String FilePath) throws EncryptedDocumentException, IOException {
		this.FilePath = FilePath;
		file = new File(FilePath);
		workbook = WorkbookFactory.create(file);
	}

	public Sheet getSheetObj(String SheetName) {
		Optional<Workbook> optional = Optional.ofNullable(workbook);
		if (optional.isPresent())
			sheet = workbook.getSheet(SheetName);
		else
			System.out.println("Workbook is pointing to null");
		return sheet;
	}

	public Sheet getSheetObj(int sheetindex) {
		Optional<Workbook> optional = Optional.ofNullable(workbook);
		if (optional.isPresent())
			sheet = workbook.getSheetAt(sheetindex);
		else
			System.out.println("Workbook is pointing to null");
		return sheet;
	}

	public String getSingleCellData(String SheetName, int RowNum, int CellNum) {
		cell = getSheetObj(SheetName).getRow(RowNum).getCell(CellNum);
		if (cell.getCellType() == CellType.STRING)
			CellValue = cell.getStringCellValue();
		else if (cell.getCellType() == CellType.NUMERIC)
			CellValue = cell.getNumericCellValue() + "";
		else if (cell.getCellType() == CellType.BOOLEAN)
			CellValue = cell.getBooleanCellValue() + "";
		return CellValue;
	}

	public List<String> getSingleRowData(String SheetName, int RowNum) {
		List<String> data = new ArrayList<String>();
		row = getSheetObj(SheetName).getRow(RowNum);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			cell = row.getCell(i);
			if (cell.getCellType() == CellType.STRING) {
				CellValue = cell.getStringCellValue();
				data.add(CellValue);
			} else if (cell.getCellType() == CellType.NUMERIC) {
				CellValue = cell.getNumericCellValue() + "";
				data.add(CellValue);
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				CellValue = cell.getBooleanCellValue() + "";
				data.add(CellValue);
			}
		}

		return data;
	}

	public List<String> getTotalSheetData(String SheetName, int RowNum, int CellNum) {
		List<String> data = new ArrayList<>();
		sheet = getSheetObj(SheetName);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++)
			row = sheet.getRow(i);
		for (int j = 0; j < row.getLastCellNum(); j++) {
			cell = row.getCell(j);
			if (cell.getCellType() == CellType.STRING) {
				CellValue = cell.getStringCellValue();
				data.add(CellValue);
			} else if (cell.getCellType() == CellType.NUMERIC) {
				CellValue = cell.getNumericCellValue() + "";
				data.add(CellValue);
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				CellValue = cell.getBooleanCellValue() + "";
				data.add(CellValue);
			}
		}
		return data;
	}

	public int findWord1(String SheetName, String word) {
		int count = 0;
       sheet = getSheetObj(SheetName);
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
			row = sheet.getRow(i);
		for (int j = 0; j < row.getLastCellNum(); j++) {
			cell = row.getCell(j);
			if (cell.getCellType() == CellType.STRING) {
				CellValue = cell.getStringCellValue();
				if (CellValue.equalsIgnoreCase(word)) {
					count++;
					System.out.println("sheet is:" + SheetName + "row is:" + i + "cell is:" + j);
				}
data.add(CellValue);
			}
			if (cell.getCellType() == CellType.NUMERIC) {
				CellValue = cell.getNumericCellValue()+"";
				if (CellValue.equalsIgnoreCase(word)) {
					count++;
					System.out.println("sheet is:" + SheetName+ "row is:" + i+ "cell is:" + j);
				}
	data.add(CellValue);
		}
			if (cell.getCellType() == CellType.BOOLEAN) {
				CellValue = cell.getBooleanCellValue()+"";
				if (CellValue.equalsIgnoreCase(word)) {
					count++;
					System.out.println("sheet is:" + SheetName + "row is:" + i + "cell is:" + j);
				}
	data.add(CellValue);
	}
	
}
}
return count;
	
	}
	public int findWord(String SheetName,String word) {
int count=0;
List<String> totaldata=new ArrayList<>();
for(String str:totaldata) {
	if(str.equalsIgnoreCase(word))
		count++;
}
return count;
	}
}
