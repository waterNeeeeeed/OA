package com.runfeng.utils.excel;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.runfeng.hibernate.HqlUtil;
import com.runfeng.hibernate.InformationEntity.PersonalInfo;
import com.runfeng.utils.JsonUtil;
import com.runfeng.utils.excel.StandardExcelParse.CellTypeOA;
import com.runfeng.utils.excel.StandardExcelParse.ColumnNumType;
import com.runfeng.utils.excel.StandardExcelParse.StandardExcelParse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/4/6.
 *
 office=经理办
 fd=财务部
 eed=设备工程部
 pwd=公用工程部
 pd=生产部
 qcd=质检部
 workshop=车间
 temp=临时用工
 all=总览

 */
public class outputExcelUtilTest {
    @Test
    public void outputExcelUtil() throws Exception {
        /*outputExcelUtil.outputExcelUtil("office", "basic");
        outputExcelUtil.outputExcelUtil("fd", "basic");
        outputExcelUtil.outputExcelUtil("eed", "basic");
        outputExcelUtil.outputExcelUtil("pwd", "basic");
        outputExcelUtil.outputExcelUtil("pd", "basic");
        outputExcelUtil.outputExcelUtil("qcd", "basic");
        outputExcelUtil.outputExcelUtil("workshop", "basic");*/
        //整合公积金基数
        Session session = HqlUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List infoList;
        StringBuffer hql = new StringBuffer();
        int i=0;
        hql.append("select distinct pi.mainID.name from PersonalInfo pi").append(" ")
                .append("where pi.contract.contractstate = ?" + i);
        infoList = session.createQuery(hql.toString()).setParameter(i+"", "江岳").list();
        System.out.println(JsonUtil.toJson(infoList));
        tx.commit();
        HqlUtil.closeSession();



        Workbook workbook = WorkbookFactory.create(new File("工资奖金/单位职工月应发工资统计表__测试.xls"));
        Sheet sheetSrc = workbook.getSheet("公积金基数");
        Sheet sheetObj = workbook.getSheet("Sheet2");


        List<ssBasic> list = new ArrayList<ssBasic>();
        ColumnNumType[] columnNumType = new ColumnNumType[2];
        columnNumType[0] = new ColumnNumType(0, CellTypeOA.STRING);
        columnNumType[1] = new ColumnNumType(1, CellTypeOA.DOUBLE);

        for(int rowIndex=1; rowIndex<178; rowIndex++){
            Row row = sheetSrc.getRow(rowIndex);
            if (!StandardExcelParse.isCellNullOrBlank(row.getCell(1))){
                list.add(StandardExcelParse.readRowToEntity(ssBasic.class, workbook, row, columnNumType));
            }

        }

        int rowIndex = 1;
        for(Iterator it=list.iterator();it.hasNext();){
            ssBasic basic = (ssBasic)it.next();
            if (infoList.contains(basic.getName())){
                Row row = sheetObj.createRow(rowIndex++);
                row.createCell(0).setCellValue(basic.getName());
                row.createCell(1).setCellValue(basic.getBasic());
            }


        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File("工资奖金/单位职工月应发工资统计表__测试_result.xls"));
        workbook.write(fileOutputStream);
        workbook.close();
    }

}