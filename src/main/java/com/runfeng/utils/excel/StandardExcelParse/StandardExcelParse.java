package com.runfeng.utils.excel.StandardExcelParse;

import com.runfeng.utils.excel.SSBasicCalculate.FullCompanySalaryExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            case DOUBLE:{
                if(isCellNumber(cell)){
                    return cell.getNumericCellValue();
                }
            }
            case DATE_YEAR:
            case DATE_YMD:
            case DATE_YM:
                {
                /*if (isCellDate(cell)){
                    return cell.getDateCellValue();
                }*/
                return cell.getRichStringCellValue().getString();
            }
        }
        return null;
    }

    private static<T> void  dateParse(Class<T> clz, Object obj, Field[] fields, int i, SimpleDateFormat sdf, String tempString)
    {
        Date date = null;
        try{
            date = sdf.parse(tempString);
            String method_name = "set" + fields[i].getName().substring(0,1).toUpperCase()
                    + fields[i].getName().substring(1);
            clz.getMethod(method_name, Date.class)
                    .invoke(obj, date);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
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
                    if (temp == null){
                        temp = "";
                    }
                    method_name = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
                    clz.getMethod(method_name, String.class)
                            .invoke(obj, temp);
                }
                break;
                //int 型
                case NUMBER:{
                    Object tempDouble = readCellValue(workbook, row, columnNumType[i]);
                    if (tempDouble == null){
                        tempDouble = 0.0;
                    }
                    Integer temp = new Double((double)tempDouble).intValue();
                    if (temp != null){
                        method_name = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
                        clz.getMethod(method_name, int.class)
                                .invoke(obj, temp);
                    }
                }
                break;
                case DOUBLE:{
                    Object tempDouble = readCellValue(workbook, row, columnNumType[i]);
                    if (tempDouble == null){
                        tempDouble = 0;
                    }
                    DecimalFormat decimalFormat = new DecimalFormat("#########0.00");
                    method_name = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
                    clz.getMethod(method_name, double.class)
                            .invoke(obj, Double.parseDouble(decimalFormat.format((double)tempDouble)));
                }
                break;
                case DATE_YEAR:
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    String tempString = (String)readCellValue(workbook, row, columnNumType[i]);
                    dateParse(clz, obj, fields, i, sdf, tempString);
                    break;
                case DATE_YMD:
                    sdf = new SimpleDateFormat("yyyy.MM.dd");
                    tempString = (String)readCellValue(workbook, row, columnNumType[i]);
                    dateParse(clz, obj, fields, i, sdf, tempString);
                    break;
                case DATE_YM:
                    sdf = new SimpleDateFormat("yyyy.MM");
                    tempString = (String)readCellValue(workbook, row, columnNumType[i]);
                    dateParse(clz, obj, fields, i, sdf, tempString);
                    break;
            }
        }

        return (T)obj;
    }


    public static void writeValueToCell(Row row, int cellNum, int value){
        CellStyle newCellStyle = row.getCell(cellNum).getCellStyle();
        Cell newCell = row.createCell(cellNum);
        newCell.setCellStyle(newCellStyle);
        newCell.setCellValue(value);
    }

    public static void writeValueToCell(Row row, int cellNum, double value){
        CellStyle newCellStyle = row.getCell(cellNum).getCellStyle();
        Cell newCell = row.createCell(cellNum);
        newCell.setCellStyle(newCellStyle);
        newCell.setCellValue(value);
    }

    public static void writeValueToCell(Row row, int cellNum, String value){
        CellStyle newCellStyle = row.getCell(cellNum).getCellStyle();
        Cell newCell = row.createCell(cellNum);
        newCell.setCellStyle(newCellStyle);
        newCell.setCellValue(value);
    }

    public static void evaluateValueToCell(Workbook wb, Row row, int cellNum){
        Cell tempCell = row.getCell(cellNum);
        if (StandardExcelParse.isCellFormula(tempCell)){
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(tempCell);
            double result = 0;
            if (cellValue.getCellType() == CELL_TYPE_NUMERIC){
                result = cellValue.getNumberValue();
            }
            Cell oldCell = row.getCell(cellNum);
            CellStyle newCellStyle = oldCell.getCellStyle();
            String newCellFormula = oldCell.getCellFormula();

            Cell newCell = row.createCell(cellNum);
            newCell.setCellStyle(newCellStyle);
            newCell.setCellValue(result);
            newCell.setCellFormula(newCellFormula);
        }
    }
}
