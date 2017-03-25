package com.runfeng.spring.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

/**
 * Created by lenovo on 2017/3/25.
 */
public class excelTest {
    public static void main(String[] args){
        try {
            Workbook wb = WorkbookFactory.create(new File("2017.xls"));
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = wb.getSheetAt(0);
            DecimalFormat    df   = new DecimalFormat("######0.00");
            for (Row row : sheet1){
                for (Cell cell : row){
                    //CellReference cellReference = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    //System.out.print(cellReference.formatAsString());
                    //System.out.print(row.getRowNum());
                    //System.out.print(cell.getColumnIndex());
                    /*String text = formatter.formatCellValue(cell);
                    System.out.print(text);*/
                    //cell.getCellTypeEnum()
                    /*switch ( evaluator.evaluateInCell(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getRichStringCellValue().getString());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue().toLocaleString());
                            } else {
                                System.out.print(cell.getNumericCellValue());
                            }
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            System.out.print("error");
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            System.out.print("");
                            break;
                    }*/
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            System.out.print(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            System.out.print(df.format(cell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.print(df.format(cell.getNumericCellValue()));
                            break;
                        case BLANK:
                            System.out.print("");
                            break;
                        default:
                            System.out.print("");
                    }
                    System.out.print("#");
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
