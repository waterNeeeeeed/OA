package com.runfeng.utils;

import com.runfeng.hibernate.EmployeeInfo;
import com.runfeng.hibernate.Salary;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/3/31.
 */
public class EmployeeInfoExcelTableParseUtil {
    public static Map<String, EmployeeInfo> inputEmployeeInfo(String filePath){
        List<EmployeeInfo> Employees = new ArrayList<>();
        Map<String, EmployeeInfo> employeeInfoMap = new HashMap<>();
        try {
            Workbook wb = WorkbookFactory.create(new File("江岳OA/江岳花名册-全部职工.xlsx"));
            Workbook wb2 = WorkbookFactory.create(new File("江岳OA/招工花名册.xls"));

            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();

            DecimalFormat df   = new DecimalFormat("######0.00");


            //读取员工姓名、性别、部门
            Sheet sheet1 = wb.getSheet("女职工（正式）");//.getSheetAt(0);
            int n = 0;
            for (int rowIndex=3; rowIndex<=sheet1.getLastRowNum(); rowIndex++){
                Row row = sheet1.getRow(rowIndex);
                if (row.getCell(0).getCellTypeEnum() != CellType.BLANK){
                    EmployeeInfo a = new EmployeeInfo();
                    a.setDepartment(row.getCell(0).getRichStringCellValue().getString());
                    a.setName(row.getCell(1).getRichStringCellValue().getString());
                    a.setSex(row.getCell(2).getRichStringCellValue().getString());
                    a.setEid(n);
                    n++;
                    employeeInfoMap.put(a.getName(), a);
                }
            }
            sheet1 = wb.getSheet("男职工（正式）");//.getSheetAt(0);
            for (int rowIndex=3; rowIndex<=sheet1.getLastRowNum(); rowIndex++){
                Row row = sheet1.getRow(rowIndex);
                if (row.getCell(0).getCellTypeEnum() != CellType.BLANK){
                    EmployeeInfo a = new EmployeeInfo();
                    a.setDepartment(row.getCell(0).getRichStringCellValue().getString());
                    a.setName(row.getCell(1).getRichStringCellValue().getString());
                    a.setSex(row.getCell(2).getRichStringCellValue().getString());
                    a.setEid(n);
                    n++;
                    employeeInfoMap.put(a.getName(), a);
                }else {
                    //System.out.println(row.getCell(1).getRichStringCellValue().getString());
                }
            }
            int totalNum = employeeInfoMap.size();
            Sheet sheet2 = wb2.getSheet("正式人员");
            DecimalFormat df2   = new DecimalFormat("######0");
            for (int rowIndex=4; rowIndex<=99; rowIndex++){
                Row row = sheet2.getRow(rowIndex);
                String name = row.getCell(3).getRichStringCellValue().getString();
                if (employeeInfoMap.containsKey(name)){
                    employeeInfoMap.get(name).setContractid("JY" + df2.format(row.getCell(2).getNumericCellValue()));
                    employeeInfoMap.get(name).setEducationalbackground(row.getCell(6).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setIdentification(row.getCell(7).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setNativeplace(row.getCell(8).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setContractstartdate(row.getCell(9).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setContractenddate(row.getCell(10).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setSchool(row.getCell(11).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setMajor(row.getCell(12).getRichStringCellValue().getString());
                    employeeInfoMap.get(name).setTelephone(row.getCell(14).getRichStringCellValue().getString());
                }
            }

            wb.close();
            wb2.close();
            /*
            int n = 0;
            for (Row row : sheet1){
                if (row.getCell(2) != null){
                    if (row.getCell(2).getCellTypeEnum() != CellType.BLANK && row.getRowNum() > 1){
                        salary[n] = new Salary();
                        for (Cell cell : row){
                            CellReference cellReference = new CellReference(row.getRowNum(), cell.getColumnIndex());
                            if (cellReference.getRow() > 1 && cellReference.getCol() >= 2
                                    && cell.getCellTypeEnum() != CellType.BLANK){
                                if (cellReference.getCol() == 2){
                                    salary[n].setName(cell.getRichStringCellValue().getString());
                                }
                                if (cellReference.getCol() == 15){
                                    salary[n].setSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 16){
                                    salary[n].setBasicSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 17){
                                    salary[n].setCheckSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 18){
                                    salary[n].setFloatingSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 19){
                                    salary[n].setFestivalSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 20){
                                    salary[n].setHolidaySalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 21){
                                    salary[n].setNightSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 22){
                                    salary[n].setSubsidySalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 23){
                                    salary[n].setTotalSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                            }
                        }
                        n++;
                    }
                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return employeeInfoMap;
    }

    public void outputEmployeeInfoToExcel(){

    }
}
