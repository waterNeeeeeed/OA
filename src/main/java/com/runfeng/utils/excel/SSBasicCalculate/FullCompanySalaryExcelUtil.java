package com.runfeng.utils.excel.SSBasicCalculate;

import com.runfeng.hibernate.InformationJson.BasicInfoHead;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/4/7.
 */
public class FullCompanySalaryExcelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FullCompanySalaryExcelUtil.class);
    private static int YEAR;
    public static Map<String, PersonalSalary> salaryExcelParse(){
        try{

            //2016年
            YEAR = 0;
            Workbook workbookYear0 = WorkbookFactory.create(new File("工资奖金/2016工资奖金汇总.xls"));
            Sheet sheet = workbookYear0.getSheet("汇总");
            String name;
            PersonalSalary personalSalary;

            DecimalFormat decimalFormat = new DecimalFormat("######0.00");
            LinkedHashMap<String, PersonalSalary> map = new LinkedHashMap<>();
            for (int i=1; i<sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);
                name = row.getCell(1).getRichStringCellValue().getString();
                if (name != null && !name.equals(""))
                {
                    if (map.containsKey(name)){
                        personalSalary = map.get(name);
                    }else {
                        personalSalary = new PersonalSalary();
                        Double[][] ss = new Double[2][12];
                        map.put(name, personalSalary);
                        personalSalary.setName(name);
                        personalSalary.setSalary(ss);
                    }
                    if (row.getCell(8) != null){
                        personalSalary.setIdentification(row.getCell(8).getRichStringCellValue().getString());
                    }

                    int month = (int)row.getCell(6).getNumericCellValue();
                    double salary = Double.parseDouble(decimalFormat.format(row.getCell(5).getNumericCellValue()));
                    personalSalary.getSalary()[YEAR][month-1] = salary;
                }
            }

            //2017 工资
            YEAR = 1;
            Workbook workbookYear1 = WorkbookFactory.create(new File("工资奖金/2017年全员工资表.xls"));

            String[] SheetName = {"1月-1", "2月-1", "1月-2", "2月-2", "1月-4", "2月-4",
                                "1月-5", "1月-3", "2月-3"};
            int NameNumber = 1;
            //开始行
            int[] SalaryRowNumber = {4, 4, 3, 3, 3, 3, 3, 2, 2};
            //工资列
            int[] SalaryCellNumber = {13, 13, 3, 3, 2, 2, 2, 10, 10};
            //月份
            int[] month = {1, 2, 1, 2, 1, 2, 1, 1, 2};
            for (int m=0; m<month.length; m++){

                Sheet sheetYear1 = workbookYear1.getSheet(SheetName[m]);
                for (int i=SalaryRowNumber[m]; i<226; i++){
                    Row row = sheetYear1.getRow(i);
                    if (row != null){
                        if (row.getCell(NameNumber) != null){
                            name = row.getCell(NameNumber).getRichStringCellValue().getString();
                            if (name != null && !name.equals(""))
                            {
                                if (map.containsKey(name)){
                                    personalSalary = map.get(name);
                                }else {
                                    personalSalary = new PersonalSalary();
                                    Double[][] ss = new Double[2][12];
                                    map.put(name, personalSalary);
                                    personalSalary.setName(name);
                                    personalSalary.setSalary(ss);
                                }
                                double salary;
                                /*if (row.getCell(SalaryCellNumber[m]).getCellTypeEnum() == CellType.FORMULA){
                                    HSSFFormulaEvaluator hfe = new HSSFFormulaEvaluator(workbookYear1);

                                }*/
                                salary = Double.parseDouble(decimalFormat.format(row.getCell(SalaryCellNumber[m]).getNumericCellValue()));

                                personalSalary.getSalary()[YEAR][month[m]-1] = salary;
                            }
                        }

                    }

                }
            }


            /*//2017 奖金
            *//*Workbook workbookYear1_1 = WorkbookFactory.create(new File(""));
            workbookYear1_1.close();*/
            YEAR = 1;
            Workbook workbookYear1Bonus = WorkbookFactory.create(new File("工资奖金/2017年全员奖金表.xls"));

            String[] SheetNameBonus = {"1月", "2月"};
            //int NameNumber = 1;
            //开始行
            int[] SalaryRowNumberBonus = {3, 3};
            //工资列
            int[] SalaryCellNumberBonus = {5, 5};
            //月份
            int[] monthBonus = {1, 2};
            for (int m=0; m<monthBonus.length; m++){

                Sheet sheetYear1Bonus = workbookYear1Bonus.getSheet(SheetNameBonus[m]);
                for (int i=SalaryRowNumberBonus[m]; i<226; i++){
                    Row row = sheetYear1Bonus.getRow(i);
                    if (row != null){
                        if (row.getCell(NameNumber) != null){
                            name = row.getCell(NameNumber).getRichStringCellValue().getString();
                            if (name != null && !name.equals(""))
                            {
                                if (map.containsKey(name)){
                                    personalSalary = map.get(name);
                                }else {
                                    personalSalary = new PersonalSalary();
                                    Double[][] ss = new Double[2][12];
                                    map.put(name, personalSalary);
                                    personalSalary.setName(name);
                                    personalSalary.setSalary(ss);
                                }
                                double bonus;
                                bonus = Double.parseDouble(decimalFormat.format(row.getCell(SalaryCellNumberBonus[m]).getNumericCellValue()));

                                //System.out.println(name + ":" + bonus);
                                personalSalary.getSalary()[YEAR][monthBonus[m]-1] += bonus;

                            }
                        }

                    }

                }
            }
            /*//2017 安全奖
            *//*Workbook workbookYear1_1 = WorkbookFactory.create(new File(""));
            workbookYear1_1.close();*/
            YEAR = 1;
            Workbook workbookYear1Safe = WorkbookFactory.create(new File("工资奖金/2017年全员奖金表.xls"));

            String[] SheetNameSafe = {"安全奖"};
            //int NameNumber = 1;
            //开始行
            int[] SalaryRowNumberSafe = {3};
            //工资列
            int[] SalaryCellNumberSafe = {3};
            //月份
            int[] monthSafe = {1};
            for (int m=0; m<monthSafe.length; m++){

                Sheet sheetYear1Safe = workbookYear1Safe.getSheet(SheetNameSafe[m]);
                for (int i=SalaryRowNumberSafe[m]; i<226; i++){
                    Row row = sheetYear1Safe.getRow(i);
                    if (row != null){
                        if (row.getCell(NameNumber) != null){
                            name = row.getCell(NameNumber).getRichStringCellValue().getString();
                            if (name != null && !name.equals(""))
                            {
                                if (map.containsKey(name)){
                                    personalSalary = map.get(name);
                                }else {
                                    personalSalary = new PersonalSalary();
                                    Double[][] ss = new Double[2][12];
                                    map.put(name, personalSalary);
                                    personalSalary.setName(name);
                                    personalSalary.setSalary(ss);
                                }
                                double bonusSafe;
                                bonusSafe = Double.parseDouble(decimalFormat.format(row.getCell(SalaryCellNumberSafe[m]).getNumericCellValue()));

                                //System.out.println(name + ":" + bonus);
                                personalSalary.getSalary()[YEAR][monthSafe[m]-1] += bonusSafe;

                            }
                        }

                    }

                }
            }

            workbookYear1Safe.close();
            workbookYear1Bonus.close();
            workbookYear0.close();
            workbookYear1.close();

            Workbook wb = new XSSFWorkbook();
            Sheet sheet1 = wb.createSheet("all");
            sheet1.autoSizeColumn(1, true);
            //表头行
            Row row = sheet1.createRow(0);
            /*int n = 0;
            for (Field field : BasicInfoHead.class.getDeclaredFields()){
                String method_name = "get"+ field.getName().substring(0,1).toUpperCase()
                        + field.getName().substring(1);
                Cell cell = row.createCell(n++);
                cell.setCellValue(String.valueOf(BasicInfoHead.class.getMethod(method_name).invoke(basicInfoHead)));
            }*/
            //表行 map
            int i = 0;
            for (Iterator it=map.keySet().iterator(); it.hasNext();){
                row = sheet1.createRow(i+1);
                i++;
                PersonalSalary temp = (PersonalSalary) map.get(it.next());
                /*map.forEach((o,v)->{

                });*/
                    Cell cell = row.createCell(0);
                    cell.setCellValue(temp.getName());
                    cell = row.createCell(1);
                    cell.setCellValue(temp.getIdentification());
                    cell = row.createCell(2);
                    cell.setCellValue(temp.getIdentification());
                    for (int z=0; z<12; z++){
                        cell = row.createCell(z+3);
                        if (temp.getSalary()[0][z] == null){
                            cell.setCellValue("0");
                        }else {
                            cell.setCellValue(temp.getSalary()[0][z]);
                        }

                    }
                    for (int z=0; z<2; z++){
                        cell = row.createCell(z+15);
                        if (temp.getSalary()[1][z] == null){
                            cell.setCellValue("0");
                        }else {
                            cell.setCellValue(temp.getSalary()[1][z]);
                        }
                    }


            }

            FileOutputStream fileOutputStream = new FileOutputStream(new File("工资奖金/test.xls"));
            wb.write(fileOutputStream);
            wb.close();
            return map;
        }catch (Exception e){
            LOGGER.error("FullCompanySalaryExcelUtil:", e);
        }
        return null;
    }

}
