package com.nomenclatureapps.exercise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nomenclatureapps.exercise.model.Nomenclatures;

public class ReadExcelFile {

	public static List<Nomenclatures> readExcellSheet(String fileName, int sheetNo) throws IOException {

		List<Nomenclatures> listOfNomenclatures = new ArrayList<>();
		// FileInputStream excelFileToRead = new FileInputStream(new
		// File("/Users/saravanan/workspace-new/NomenclaturesSystem/src/main/resources/Nomencaltural.xlsx"));
		
		FileInputStream excelFileToRead = new FileInputStream(new File(fileName));
		try (Workbook workbook = new XSSFWorkbook(excelFileToRead)) {
			DataFormatter dataformatter = new DataFormatter();
			Sheet sheet = workbook.getSheetAt(sheetNo);
			int lastRowNum = sheet.getLastRowNum();

			for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {
				Row row = sheet.getRow(rowNum);
				long orderId = dataformatter.formatCellValue(row.getCell(0)).isEmpty() ? 0
						: Integer.parseInt(dataformatter.formatCellValue(row.getCell(0)));
				int level = dataformatter.formatCellValue(row.getCell(1)).isEmpty() ? 0
						: Integer.parseInt(dataformatter.formatCellValue(row.getCell(1)));

				listOfNomenclatures.add(new Nomenclatures(0, orderId, level,
						dataformatter.formatCellValue(row.getCell(2)), dataformatter.formatCellValue(row.getCell(3)),
						dataformatter.formatCellValue(row.getCell(4)), dataformatter.formatCellValue(row.getCell(5)),
						dataformatter.formatCellValue(row.getCell(6)), dataformatter.formatCellValue(row.getCell(7)),
						dataformatter.formatCellValue(row.getCell(8)), dataformatter.formatCellValue(row.getCell(9))));
			}
			//System.out.println(listOfNomenclatures.size());
		}

		return listOfNomenclatures;

	}

}
