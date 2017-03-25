package com.runfeng.spring.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2017/3/25.
 */
public class excelTest {
    public static void main(String[] args){
        try {
            Workbook wb = WorkbookFactory.create(new File("2017.xls"));
            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = wb.getSheetAt(0);
            for (Row row : sheet1){
                for (Cell cell : row){
                    //CellReference cellReference = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    //System.out.print(cellReference.formatAsString());
                    //System.out.print(row.getRowNum());
                    //System.out.print(cell.getColumnIndex());
                    String text = formatter.formatCellValue(cell);
                    System.out.print(text);

                    switch (cell.getCellTypeEnum()) {
                        case CellType.STRING:
                            System.out.print(cell.getRichStringCellValue().getString());
                            break;
                        case CellType.NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue());
                            } else {
                                System.out.print(cell.getNumericCellValue());
                            }
                            break;
                        case CellType.BOOLEAN:
                            System.out.print(cell.getBooleanCellValue());
                            break;
                        case CellType.FORMULA:
                            System.out.print(cell.getCellFormula());
                            break;
                        case CellType.BLANK:
                            System.out.print("");
                            break;
                        default:
                            System.out.print("");
                    }

                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}
