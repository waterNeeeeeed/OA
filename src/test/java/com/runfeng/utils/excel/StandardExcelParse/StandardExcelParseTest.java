package com.runfeng.utils.excel.StandardExcelParse;

import com.runfeng.hibernate.InformationEntity.MainID;
import com.runfeng.hibernate.SalaryEntity.CAJiangYue;
import com.runfeng.hibernate.SalaryEntity.SSBasic;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.*;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

/**
 * Created by lenovo on 2017/4/12.
 */
public class StandardExcelParseTest {
    @Test
    public void readRowToEntityTest() throws Exception {
        Workbook workbook = WorkbookFactory
                .create(new File("江岳OA/考勤/2017年5月考勤表模板.xls"));

        String[] SheetName = {"公司领导", "经理办", "财务部", "设备工程部", "公用工程部", "生产部",
                                "质检部", "车间1", "车间2", "车间3", "车间4"};
        List<CAJiangYue> caJiangYue = new ArrayList<>();
        int rowStart = 4;
        int nameCellIndex = 1;
        //以后固定18行
        int[] rowStops = {21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21};
        //固定不变
        int[] nums = {0, 1, 4, 5, 6, 7, 8, 19, 20, 18, 12, 11, 15};
        CellTypeOA[] cellTypeOAS = {CellTypeOA.NUMBER, CellTypeOA.STRING, CellTypeOA.NUMBER,
                CellTypeOA.NUMBER, CellTypeOA.NUMBER, CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                CellTypeOA.NUMBER,CellTypeOA.NUMBER};
        ColumnNumType[] columnNumType = new ColumnNumType[nums.length];

        for (int i=0; i<cellTypeOAS.length; i++){
            columnNumType[i] = new ColumnNumType(nums[i], cellTypeOAS[i]);
        }

        for(int m=0; m<SheetName.length; m++){

            int rowStop = rowStops[m];
            Sheet sheet = workbook.getSheet(SheetName[m]);
            for (int n=rowStart; n <= rowStop; n++){
                if (sheet.getRow(n) != null){
                    if(!StandardExcelParse.isCellNullOrBlank(sheet.getRow(n).getCell(nameCellIndex))){
                        caJiangYue.add(StandardExcelParse.readRowToEntity(CAJiangYue.class, workbook, sheet.getRow(n), columnNumType));
                    }
                }

            }

        }
        workbook.close();

        /*Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "select distinct pi.mainID from PersonalInfo pi";
        List<MainID> temp = sess.createQuery(hql).list();



        for(Iterator<MainID> it=temp.iterator(); it.hasNext(); ){
            MainID mainID = it.next();
            if (ssBasicMap.containsKey(mainID.getName())) {
                ssBasicMap.get(mainID.getName()).setEid(mainID.getEid());
                sess.save(ssBasicMap.get(mainID.getName()));
            }
        }
        tx.commit();
        sess.close();
        sf.close();*/


        //将数据写入2017全员考勤表
        Map<String, CAJiangYue> caJiangYueMap = new LinkedHashMap<>();
        for (Iterator it=caJiangYue.iterator(); it.hasNext();){
            CAJiangYue caJiangYue1 = (CAJiangYue)it.next();
            caJiangYueMap.put(caJiangYue1.getName(), caJiangYue1);
        }
        workbook.close();
        Workbook wb = WorkbookFactory.create(new File("江岳OA/考勤/2017全员考勤表_完整.xls"));
        Sheet sheet1 = wb.getSheet("2017-5");
        Field[] fields = CAJiangYue.class.getDeclaredFields();

        for(int i=2; i<118; i++){
            Row row = sheet1.getRow(i);
            Cell nameCell = row.getCell(2);
            if (StandardExcelParse.isCellNullOrBlank(nameCell) || !caJiangYueMap.containsKey(nameCell.getRichStringCellValue().getString())){
                continue;
            }
            String name = nameCell.getRichStringCellValue().getString();
            //考勤入表
            for(int cellNum=3; cellNum<14; cellNum++){
                String methodName = "get" + fields[cellNum-1].getName().substring(0,1).toUpperCase()
                        + fields[cellNum-1].getName().substring(1);
                int temp = (int)CAJiangYue.class.getMethod(methodName).invoke(caJiangYueMap.get(name));
                StandardExcelParse.writeValueToCell(row, cellNum, temp);
            }
            //计算结果
            for(int cellNum=18; cellNum<=23; cellNum++){
                StandardExcelParse.evaluateValueToCell(wb, row, cellNum);
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File("江岳OA/考勤/2017全员考勤表_定稿" + ".xls"));
        wb.write(fileOutputStream);
        wb.close();
    }

    public void readRowToEntityTest2() throws Exception {
        /*Workbook workbook = WorkbookFactory
                .create(new File("江岳OA/考勤/2017年4月考勤表模板.xls"));

        String[] SheetName = {"公司领导", "经理办", "财务部", "设备工程部", "公用工程部", "生产部",
                                "质检部", "车间1", "车间2", "车间3"};
        List<CAJiangYue> caJiangYue = new ArrayList<>();
        //以后固定18行
        int[] rowStops = {21, 21, 21, 21, 21, 21, 21, 21, 21, 21};
        //固定不变
        int[] nums = {0, 1, 4, 5, 6, 7, 8, 19, 20, 18, 12, 11, 15};
        CellTypeOA[] cellTypeOAS = {CellTypeOA.NUMBER, CellTypeOA.STRING, CellTypeOA.NUMBER,
                CellTypeOA.NUMBER, CellTypeOA.NUMBER, CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,CellTypeOA.NUMBER,
                CellTypeOA.NUMBER,CellTypeOA.NUMBER};
        ColumnNumType[] columnNumType = new ColumnNumType[nums.length];*/
        Workbook workbook = WorkbookFactory
                .create(new File("江岳OA/社保/[0700127149]_基数申报_1492073753367_RESULT.xls"));

        String[] SheetName = {"assets"};
        //List<SSBasic> ssBasics = new ArrayList<>();
        Map<String, SSBasic> ssBasicMap = new HashMap<>();
        int rowStart = 1;
        //以后固定18行
        int[] rowStops = {94};
        //固定不变
        int[] nums = {0, 1, 2, 3};
        CellTypeOA[] cellTypeOAS = {CellTypeOA.NUMBER, CellTypeOA.STRING, CellTypeOA.DATE_YEAR, CellTypeOA.DOUBLE};
        ColumnNumType[] columnNumType = new ColumnNumType[nums.length];
        int nameCellIndex = 1;

        for (int i=0; i<cellTypeOAS.length; i++){
            columnNumType[i] = new ColumnNumType(nums[i], cellTypeOAS[i]);
        }

        for(int m=0; m<SheetName.length; m++){

            int rowStop = rowStops[m];
            Sheet sheet = workbook.getSheet(SheetName[m]);
            for (int n=rowStart; n <= rowStop; n++){
                if (sheet.getRow(n) != null){
                    if(!StandardExcelParse.isCellNullOrBlank(sheet.getRow(n).getCell(nameCellIndex))){
                        ssBasicMap.put((String)StandardExcelParse.readCellValue(workbook, sheet.getRow(n), new ColumnNumType(nameCellIndex, CellTypeOA.STRING)),
                                StandardExcelParse.readRowToEntity(SSBasic.class, workbook, sheet.getRow(n), columnNumType));
                        //ssBasics.add(StandardExcelParse.readRowToEntity(SSBasic.class, workbook, sheet.getRow(n), columnNumType));
                    }
                }

            }

        }
        workbook.close();

        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hql = "select distinct pi.mainID from PersonalInfo pi";
        List<MainID> temp = sess.createQuery(hql).list();



        for(Iterator<MainID> it=temp.iterator(); it.hasNext(); ){
            MainID mainID = it.next();
            if (ssBasicMap.containsKey(mainID.getName())) {
                ssBasicMap.get(mainID.getName()).setEid(mainID.getEid());
                sess.save(ssBasicMap.get(mainID.getName()));
            }
        }
        tx.commit();
        sess.close();
        sf.close();
        //2017年5月全员社会保险明细
        /*Workbook wb = WorkbookFactory.create(new File("江岳OA\\社保\\2017年5月全员社会保险明细.xls"));
        Sheet sheet1 = wb.getSheet("2017-5");
        Field[] fields = SSBasic.class.getDeclaredFields();


        for(int i=2; i<118; i++){
            Row row = sheet1.getRow(i);
            if (row == null){
                continue;
            }
            Cell nameCell = row.getCell(3);
            if (StandardExcelParse.isCellNullOrBlank(nameCell) || !ssBasicMap.containsKey(nameCell.getRichStringCellValue().getString())){
                if (!StandardExcelParse.isCellNullOrBlank(nameCell) && nameCell.getRichStringCellValue().getString().equals("合计")){
                    for(int cellNum=4; cellNum<=16; cellNum++){
                        StandardExcelParse.evaluateValueToCell(wb, row, cellNum);
                    }
                }
                continue;
            }
            String name = nameCell.getRichStringCellValue().getString();
            StandardExcelParse.writeValueToCell(row, 4, ssBasicMap.get(name).getSsBasicData());

            for(int cellNum=5; cellNum<=15; cellNum++){
                StandardExcelParse.evaluateValueToCell(wb, row, cellNum);
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File("江岳OA\\社保\\2017年5月全员社会保险明细__" + ".xls"));
        wb.write(fileOutputStream);
        wb.close();*/

        //将数据写入2017全员考勤表
        /*Map<String, CAJiangYue> caJiangYueMap = new LinkedHashMap<>();
        for (Iterator it=ssBasics.iterator(); it.hasNext();){
            CAJiangYue caJiangYue1 = (CAJiangYue)it.next();
            caJiangYueMap.put(caJiangYue1.getName(), caJiangYue1);
        }
        workbook.close();
        Workbook wb = WorkbookFactory.create(new File("江岳OA/考勤/2017全员考勤表.xls"));
        Sheet sheet1 = wb.getSheet("2017-4");
        Field[] fields = CAJiangYue.class.getDeclaredFields();

        for(int i=2; i<118; i++){
            Row row = sheet1.getRow(i);
            Cell nameCell = row.getCell(2);
            if (StandardExcelParse.isCellNullOrBlank(nameCell) || !caJiangYueMap.containsKey(nameCell.getRichStringCellValue().getString())){
                continue;
            }
            String name = nameCell.getRichStringCellValue().getString();
            //考勤入表
            for(int cellNum=3; cellNum<14; cellNum++){
                String methodName = "get" + fields[cellNum-1].getName().substring(0,1).toUpperCase()
                        + fields[cellNum-1].getName().substring(1);
                int temp = (int)CAJiangYue.class.getMethod(methodName).invoke(caJiangYueMap.get(name));
                StandardExcelParse.writeValueToCell(row, cellNum, temp);
            }
            //计算结果
            for(int cellNum=18; cellNum<=23; cellNum++){
                StandardExcelParse.evaluateValueToCell(wb, row, cellNum);
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File("江岳OA/考勤/2017全员考勤表_完整" + ".xls"));
        wb.write(fileOutputStream);
        wb.close();*/
    }
}