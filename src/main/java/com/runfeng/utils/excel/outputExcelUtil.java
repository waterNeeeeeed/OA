package com.runfeng.utils.excel;

import com.runfeng.hibernate.HqlQuery;
import com.runfeng.hibernate.HqlUtil;
import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationJson.BasicInfoHead;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;
import com.runfeng.utils.TableHeadParseUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.runfeng.hibernate.HqlQuery.queryBasicInfoList;

/**
 * Created by lenovo on 2017/4/6.
 */
public class outputExcelUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(outputExcelUtil.class);

    public static void outputExcelUtil(String department, String infoType){
        if (infoType.equals("basic")){
            List<BasicInfoJson> list = HqlQuery.queryBasicInfoList(department);
            BasicInfoHead basicInfoHead = (BasicInfoHead)TableHeadParseUtil.getTableHead("tablehead/basicinfo_tablehead",
                    "com.runfeng.hibernate.InformationJson.BasicInfoHead");
            try {
                Workbook wb = new XSSFWorkbook();
                Sheet sheet1 = wb.createSheet("基本信息");
                sheet1.autoSizeColumn(1, true);
                //表头行
                Row row = sheet1.createRow(0);
                int n = 0;
                for (Field field : BasicInfoHead.class.getDeclaredFields()){
                    String method_name = "get"+ field.getName().substring(0,1).toUpperCase()
                            + field.getName().substring(1);
                    Cell cell = row.createCell(n++);
                    cell.setCellValue(String.valueOf(BasicInfoHead.class.getMethod(method_name).invoke(basicInfoHead)));
                }
                //表行
                for (int i = 0; i < list.size(); i++){
                    BasicInfoJson temp = list.get(i);
                    row = sheet1.createRow(i+1);
                    int m = 0;
                    for (Field field : BasicInfoJson.class.getDeclaredFields()){
                        String method_name = "get"+ field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
                        Cell cell = row.createCell(m++);
                        String temp_value = String.valueOf(BasicInfoJson.class.getMethod(method_name).invoke(temp));
                        if (temp_value.equals("")){
                            cell.setCellValue("");
                        }else {
                            cell.setCellValue(temp_value);
                        }

                    }
                }

                FileOutputStream fileOutputStream = new FileOutputStream(new File(department + ".xlsx"));
                wb.write(fileOutputStream);
                wb.close();

            } catch (Exception e) {
                LOGGER.error("error:", e);
            }
        }

    }

}

