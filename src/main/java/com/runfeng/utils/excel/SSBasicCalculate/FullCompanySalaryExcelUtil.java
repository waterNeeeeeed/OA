package com.runfeng.utils.excel.SSBasicCalculate;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/4/7.
 */
public class FullCompanySalaryExcelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FullCompanySalaryExcelUtil.class);
    public static Map<String, PersonalSalary> salaryExcelParse(){
        try{
            Workbook workbook = WorkbookFactory.create(new File("2016工资奖金汇总.xls"));
            Sheet sheet = workbook.getSheet("汇总");

            String name;
            PersonalSalary personalSalary;

            DecimalFormat decimalFormat = new DecimalFormat("######0.00");
            Map<String, PersonalSalary> map = new LinkedHashMap<>();
            for (int i=1; i<sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);
                name = row.getCell(1).getRichStringCellValue().getString();
                if (name != null && !name.equals(""))
                {
                    if (map.containsKey(name)){
                        personalSalary = map.get(name);
                    }else {
                        personalSalary = new PersonalSalary();
                        Double[] ss = new Double[12];
                        map.put(name, personalSalary);
                        personalSalary.setName(name);
                        personalSalary.setSalary(ss);
                    }
                    if (row.getCell(8) != null){
                        personalSalary.setIdentification(row.getCell(8).getRichStringCellValue().getString());
                    }

                    int month = (int)row.getCell(6).getNumericCellValue();
                    double salary = Double.parseDouble(decimalFormat.format(row.getCell(5).getNumericCellValue()));
                    personalSalary.getSalary()[month-1] = salary;
                }
            }

            return map;
        }catch (Exception e){
            LOGGER.error("FullCompanySalaryExcelUtil:", e);
        }
        return null;
    }

}
