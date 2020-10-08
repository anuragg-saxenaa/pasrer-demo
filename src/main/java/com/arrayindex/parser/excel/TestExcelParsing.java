package com.arrayindex.parser.excel;

public class TestExcelParsing {

    static String excelPath = "./src/main/java/com/arrayindex/parser/excel/TestData.xlsx";


    public static void main(String[] args) throws Exception {
        ExcelUtil2 excel = new ExcelUtil2(excelPath);
        Object row1 = excel.getExcelData("Sheet1", "Order Total", 2);
        Object row5 = excel.getExcelData("Sheet1", "Zipcode", 5);
        System.out.println(row1 + "\n" + row5);
    }

}
