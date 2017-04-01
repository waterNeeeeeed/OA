package com.runfeng.utils;

import com.runfeng.hibernate.Salary;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/4/1.
 */
public class SalaryExcelTableParseUtil {
    public static List<Salary> inputSalary(){
        List<Salary> salary = new ArrayList<>();
        try {
            Workbook wb = WorkbookFactory.create(new File("2017.xls"));
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = wb.getSheetAt(0);
            DecimalFormat df   = new DecimalFormat("######0.00");


            Salary temp;
            int n = 0;
            for (Row row : sheet1){
                if (row.getCell(2) != null){
                    if (row.getCell(2).getCellTypeEnum() != CellType.BLANK && row.getRowNum() > 1){
                        temp = new Salary();
                        for (Cell cell : row){
                            CellReference cellReference = new CellReference(row.getRowNum(), cell.getColumnIndex());
                            if (cellReference.getRow() > 1 && cellReference.getCol() >= 2
                                    && cell.getCellTypeEnum() != CellType.BLANK){
                                if (cellReference.getCol() == 2){
                                    temp.setName(cell.getRichStringCellValue().getString());
                                }
                                if (cellReference.getCol() == 15){
                                    temp.setSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 16){
                                    temp.setBasicSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 17){
                                    temp.setCheckSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 18){
                                    temp.setFloatingSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 19){
                                    temp.setFestivalSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 20){
                                    temp.setHolidaySalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 21){
                                    temp.setNightSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 22){
                                    temp.setSubsidySalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 23){
                                    temp.setTotalSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                            }
                        }
                        salary.add(temp);
                        n++;
                    }
                }
            }
            /*Configuration conf = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

            Session sess = sf.openSession();
            Transaction tx = sess.beginTransaction();*/
            int i=0;
            for (Iterator<Salary> it = salary.iterator(); it.hasNext(); ) {
                Salary s = it.next();
                s.setEid(i++);
                s.setDate(new Date());
            }

            wb.close();
            /*tx.commit();
            sess.close();
            sf.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return salary;
    }
}
