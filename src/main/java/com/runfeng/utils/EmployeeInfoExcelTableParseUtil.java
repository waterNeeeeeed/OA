package com.runfeng.utils;

import com.runfeng.hibernate.EmployeeInfo;
import com.runfeng.hibernate.Salary;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/3/31.
 */
public class EmployeeInfoExcelTableParseUtil {
    public static void inputEmployeeInfo(String filePath){
        try {
            Workbook wb = WorkbookFactory.create(new File("江岳OA/江岳花名册-全部职工.xlsx"));
            Workbook wb2 = WorkbookFactory.create(new File("江岳OA/招工花名册.xls"));

            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();

            DecimalFormat df   = new DecimalFormat("######0.00");

            List<EmployeeInfo> Employees = new ArrayList<>();
            Map<String, EmployeeInfo> employeeInfoMap = new HashMap<>();
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
            for (Map.Entry<String, EmployeeInfo> entry : employeeInfoMap.entrySet()){
                System.out.println(JsonUtil.toJson(entry.getValue()));
            }
            Sheet sheet2 = wb2.getSheet("正式人员");
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
            /*Configuration conf = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

            Session sess = sf.openSession();
            Transaction tx = sess.beginTransaction();*/
            /*Salary[] salary2;
            for (int i=0; i<n; i++){
                salary[i].setEid(i);
                salary[i].setDate(new Date());
                *//*sess.save(test[i]);*//*
            }
            salary2 = Arrays.copyOf(salary, n);
            employeesSalary = JsonUtil.toJson(salary2);
            salaryTableHead = convertTableHeadToJson();*/

            wb.close();
            wb2.close();
            /*tx.commit();
            sess.close();
            sf.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public void outputEmployeeInfoToExcel(){

    }
}
