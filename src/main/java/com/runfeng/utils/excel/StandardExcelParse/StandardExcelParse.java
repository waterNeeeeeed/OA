package com.runfeng.utils.excel.StandardExcelParse;

import com.runfeng.utils.excel.SSBasicCalculate.FullCompanySalaryExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

/**
 * Created by lenovo on 2017/4/12.
 */
public class StandardExcelParse {
    private static final Logger LOGGER = LoggerFactory.getLogger(FullCompanySalaryExcelUtil.class);
    private static int YEAR;

    public static boolean isCellNullOrBlank(Cell cell){
        if (cell == null || cell.getCellTypeEnum() == CellType.BLANK){
            return true;
        }
        return false;
    }

    public static boolean isCellFormula(Cell cell){
        return cell.getCellTypeEnum() == CellType.FORMULA;
    }

    public static boolean isCellString(Cell cell){
        return cell.getCellTypeEnum() == CellType.STRING;
    }

    //纯数字非日期
    public static boolean isCellNumber(Cell cell){
        if (cell.getCellTypeEnum() == CellType.NUMERIC
                && !DateUtil.isCellDateFormatted(cell)){
            return true;
        }
        return false;
    }

    //日期
    public static boolean isCellDate(Cell cell){
        if (cell.getCellTypeEnum() == CellType.NUMERIC
                && DateUtil.isCellDateFormatted(cell)){
            return true;
        }
        return false;
    }

    //仅仅支持数字公式计算
    public static Object readCellValue(Workbook workbook, Row row, ColumnNumType columnNumType){
        Cell cell = row.getCell(columnNumType.getColumnNum());
        //如果为空直接返回空
        if (isCellNullOrBlank(cell)){
            return null;
        }
        switch (columnNumType.getColumnType()){
            case STRING:{
                if(isCellString(cell)){
                    return cell.getRichStringCellValue().getString();
                }
            }
            case FORMULA:{
                FormulaEvaluator evaluator =workbook.getCreationHelper().createFormulaEvaluator();
                CellValue cellValue = evaluator.evaluate(cell);
                if (cellValue.getCellType() == CELL_TYPE_NUMERIC){
                    return cellValue.getNumberValue();
                }
            }
            case NUMBER:{
                if(isCellNumber(cell)){
                    return cell.getNumericCellValue();
                }
            }
            case DATE:{
                if (isCellDate(cell)){
                    return cell.getDateCellValue();
                }
            }
        }
        return null;
    }

    public static <T> T readRowToEntity(Class<T> clz, Workbook workbook, Row row, ColumnNumType[] columnNumType)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        Object obj = clz.newInstance();
        Field[] fields = clz.getDeclaredFields();
        String method_name;
        CellTypeOA columnTypeTemp;

        for (int i=0; i<columnNumType.length; i++){
            columnTypeTemp = columnNumType[i].getColumnType();
            switch (columnTypeTemp){
                case STRING:{
                    String temp = (String)readCellValue(workbook, row, columnNumType[i]);
                    if (temp != null){
                        method_name = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
                        clz.getMethod(method_name, String.class)
                                .invoke(obj, temp);
                    }
                }
                break;
                case NUMBER:{
                    Object tempDouble = readCellValue(workbook, row, columnNumType[i]);
                    if (tempDouble != null){
                        Integer temp = new Double((double)tempDouble).intValue();
                        if (temp != null){
                            method_name = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
                            clz.getMethod(method_name, int.class)
                                    .invoke(obj, temp.intValue());
                        }
                    }
                }
                break;
            }
        }

        return (T)obj;
    }

}
