package com.runfeng.utils.excel;

import com.runfeng.hibernate.InformationEntity.EmployeeInfo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/3/31.
 * 期初建立信息
 */
public class EmployeeInfoExcelTableParseUtil {
    private static int EMPLOYEE_NUMBER = 112;
    public static Map<String, EmployeeInfo> inputEmployeeInfo(String filePath){

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
                    a.setPost(row.getCell(3).getRichStringCellValue().getString());
                    a.setPosition(row.getCell(4).getRichStringCellValue().getString());
                    a.setPositionstate(row.getCell(5).getRichStringCellValue().getString());
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
                    a.setPost(row.getCell(3).getRichStringCellValue().getString());
                    a.setPosition(row.getCell(4).getRichStringCellValue().getString());
                    a.setPositionstate(row.getCell(5).getRichStringCellValue().getString());
                    employeeInfoMap.put(a.getName(), a);
                }else {
                    //System.out.println(row.getCell(1).getRichStringCellValue().getString());
                }
            }
            //读取EID
            sheet1 = wb.getSheet("正式职工");
            DecimalFormat eid = new DecimalFormat("#####");
            for (int rowIndex=1; rowIndex<=EMPLOYEE_NUMBER; rowIndex++){
                Row row = sheet1.getRow(rowIndex);
                if (row.getCell(0).getCellTypeEnum() != CellType.BLANK){
                    String key = row.getCell(1).getRichStringCellValue().getString();
                    int number = Integer.parseInt(eid.format(row.getCell(0).getNumericCellValue()));
                    employeeInfoMap.get(key).setEid(number);
                    //工号暂用ＥＩＤ
                    employeeInfoMap.get(key).setWorkid(number);
                }else {
                    employeeInfoMap.get(row.getCell(1).getRichStringCellValue().getString())
                            .setEid(999999);
                }
            }
            String[] sheetName = {"正式人员", "非合同"};
            for (int i=0; i<2; i++){
                Sheet sheet2 = wb2.getSheet(sheetName[i]);
                DecimalFormat df2   = new DecimalFormat("######0");
                DecimalFormat telephone = new DecimalFormat("############");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                for (int rowIndex=4; rowIndex<=102; rowIndex++){
                    Row row = sheet2.getRow(rowIndex);
                    String name = row.getCell(3).getRichStringCellValue().getString();
                    //包含就读，不包含就过
                    if (employeeInfoMap.containsKey(name)){
                        //如果合同号为空则认为没签
                        if (!isCellNull(row, 2)){
                            if (row.getCell(2).getCellTypeEnum() == CellType.BLANK){
                                employeeInfoMap.get(name).setContractid("-");
                            }else {
                                StringBuffer contractid = new StringBuffer().append(row.getCell(1).getRichStringCellValue().getString());
                                contractid.append(df2.format(row.getCell(2).getNumericCellValue()));
                                employeeInfoMap.get(name).setContractid(contractid.toString());
                            }
                        }
                        else {
                            employeeInfoMap.get(name).setContractid("-");
                        }

                        employeeInfoMap.get(name).setEducationalbackground(row.getCell(6).getRichStringCellValue().getString());
                        employeeInfoMap.get(name).setIdentification(row.getCell(7).getRichStringCellValue().getString());
                        employeeInfoMap.get(name).setNativeplace(row.getCell(8).getRichStringCellValue().getString());
                        if (row.getCell(9).getCellTypeEnum() != CellType.BLANK && row.getCell(10).getCellTypeEnum() != CellType.BLANK){
                            employeeInfoMap.get(name).setContractstartdate(sdf.parse(row.getCell(9).getRichStringCellValue().getString()));
                            employeeInfoMap.get(name).setContractenddate(sdf.parse(row.getCell(10).getRichStringCellValue().getString()));
                        }
                        //employeeInfoMap.get(name).setContractenddate(row.getCell(10).getDateCellValue());//row.getCell(10).getRichStringCellValue().getString());
                        employeeInfoMap.get(name).setSchool(row.getCell(11).getRichStringCellValue().getString());
                        employeeInfoMap.get(name).setSchoolform(row.getCell(12).getRichStringCellValue().getString());
                        employeeInfoMap.get(name).setMajor(row.getCell(13).getRichStringCellValue().getString());

                        employeeInfoMap.get(name).setContractstate(row.getCell(16).getRichStringCellValue().getString());
                        if (row.getCell(17).getCellTypeEnum() != CellType.BLANK ){
                            employeeInfoMap.get(name).setContractfirstsigndate(sdf.parse(row.getCell(17).getRichStringCellValue().getString()));
                        }
                    }
                }
                //电话
                sheet2 = wb2.getSheet("电话");
                for (int rowIndex=1; rowIndex<=sheet2.getLastRowNum(); rowIndex++){
                    Row row = sheet2.getRow(rowIndex);
                    if (row.getCell(1).getCellTypeEnum() != CellType.BLANK){
                        String name = row.getCell(1).getRichStringCellValue().getString();
                        if (employeeInfoMap.containsKey(name)){
                            if (row.getCell(2) != null){
                                employeeInfoMap.get(name).setTelephone(telephone.format(row.getCell(2).getNumericCellValue()));
                            }else {
                                employeeInfoMap.get(name).setTelephone("-");
                            }
                        }
                    }

                }
            }


            wb.close();
            wb2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return employeeInfoMap;
    }

    public static boolean isCellNull(Row row, int index){
        return row.getCell(index) == null;
    }
    public void outputEmployeeInfoToExcel(){

    }
}
