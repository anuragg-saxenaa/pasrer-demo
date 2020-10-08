package com.arrayindex.parser.excel;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil2 {
    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;

    public ExcelUtil2(String xlFilePath) throws Exception {
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }

    public Object getExcelData(String sheetName, String colName, int rowNum) {

        int col_num = -1;
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return "";

        sheet = workbook.getSheetAt(index);

        row = sheet.getRow(rowNum - 2);

        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                col_num = i;
        }

        row = sheet.getRow(rowNum - 1);
        cell = row.getCell(col_num);

        DataFormatter formatter = new DataFormatter();
        Object excelData = formatter.formatCellValue(cell);

        return excelData;

    }
}
