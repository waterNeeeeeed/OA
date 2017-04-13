package com.runfeng.utils.excel;

import com.runfeng.hibernate.HqlUtil;
import com.runfeng.utils.JsonUtil;
import com.runfeng.utils.excel.StandardExcelParse.CellTypeOA;
import com.runfeng.utils.excel.StandardExcelParse.ColumnNumType;
import com.runfeng.utils.excel.StandardExcelParse.StandardExcelParse;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

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
        /*Session session = HqlUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List infoList;
        StringBuffer hql = new StringBuffer();
        int i=0;
        hql.append("select distinct pi.mainID.name from PersonalInfo pi").append(" ")
                .append("where pi.contract.contractstate = ?" + i);
        infoList = session.createQuery(hql.toString()).setParameter(i+"", "江岳").list();
        System.out.println(JsonUtil.toJson(infoList));
        tx.commit();
        HqlUtil.closeSession();*/



        Workbook workbookSrc = WorkbookFactory.create(new File("江岳OA/社保/2017社保基数_最终.xls"));
        Sheet sheetSrc = workbookSrc.getSheet("2017社保基数最终稿");
        Workbook workbookObj = WorkbookFactory.create(new File("江岳OA/社保/[0700127149]_基数申报_1492073753367_.xls"));
        Sheet sheetObj = workbookObj.getSheet("assets");


        List<SSBasic> ssBasicList = new ArrayList<SSBasic>();
        ColumnNumType[] columnNumType = new ColumnNumType[2];
        columnNumType[0] = new ColumnNumType(0, CellTypeOA.STRING);
        columnNumType[1] = new ColumnNumType(2, CellTypeOA.DOUBLE);

        for(int rowIndex=1; rowIndex<=93; rowIndex++){
            Row row = sheetSrc.getRow(rowIndex);
            Cell temp = row.getCell(0);
            if (!StandardExcelParse.isCellNullOrBlank(temp)){
                ssBasicList.add(StandardExcelParse.readRowToEntity(SSBasic.class, workbookSrc, row, columnNumType));
            }

        }

        Map<String, SSBasic> ssBasicMap = new LinkedHashMap<>();
        for(Iterator it=ssBasicList.iterator();it.hasNext();){
            SSBasic temp = (SSBasic)it.next();
            ssBasicMap.put(temp.getName(), temp);
        }

        int rowIndex = 1;
        for (int i=1; i<=93; i++)
        {
            Row rowObj = sheetObj.getRow(i);
            if (!StandardExcelParse.isCellNullOrBlank(rowObj.getCell(1))){
                String name = (String)StandardExcelParse.readCellValue(workbookObj, rowObj, new ColumnNumType(1, CellTypeOA.STRING));
                rowObj.createCell(3).setCellValue(ssBasicMap.get(name).getBasic());
            }

        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File("江岳OA/社保/[0700127149]_基数申报_1492073753367_RESULT.xls"));
        workbookObj.write(fileOutputStream);
        workbookSrc.close();
        workbookObj.close();
    }

}