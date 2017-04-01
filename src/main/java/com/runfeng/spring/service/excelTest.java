package com.runfeng.spring.service;

import com.runfeng.hibernate.SalaryEntity.Salary;
import com.runfeng.hibernate.SalaryEntity.SalaryTableRow;
import com.runfeng.utils.JsonUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;


/**
 * Created by lenovo on 2017/3/25.
 */
public class excelTest {
    public static void main(String[] args){
        try {
            Workbook wb = WorkbookFactory.create(new File("2017.xls"));
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = wb.getSheetAt(0);
            DecimalFormat    df   = new DecimalFormat("######0.00");

            SalaryTableRow[] test = new SalaryTableRow[1000];
            int n = 0;
            for (Row row : sheet1){
                if (row.getCell(2) != null){
                    if (row.getCell(2).getCellTypeEnum() != CellType.BLANK && row.getRowNum() > 1){
                        test[n] = new SalaryTableRow(new Salary());
                        for (Cell cell : row){
                            CellReference cellReference = new CellReference(row.getRowNum(), cell.getColumnIndex());
                            if (cellReference.getRow() > 1 && cellReference.getCol() >= 2
                                    && cell.getCellTypeEnum() != CellType.BLANK){
                                if (cellReference.getCol() == 2){
                                    test[n].getSalary().setName(cell.getRichStringCellValue().getString());
                                }
                                if (cellReference.getCol() == 15){
                                    test[n].getSalary().setSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 16){
                                    test[n].getSalary().setBasicSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 17){
                                    test[n].getSalary().setCheckSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 18){
                                    test[n].getSalary().setFloatingSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 19){
                                    test[n].getSalary().setFestivalSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 20){
                                    test[n].getSalary().setHolidaySalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 21){
                                    test[n].getSalary().setNightSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 22){
                                    test[n].getSalary().setSubsidySalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }
                                if (cellReference.getCol() == 23){
                                    test[n].getSalary().setTotalSalary(Double.parseDouble(df.format(cell.getNumericCellValue())));
                                }

                        /*
                        switch (cell.getCellTypeEnum()) {
                            case STRING:
                                System.out.print(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                System.out.print(df.format(cell.getNumericCellValue()));
                                break;
                            case BOOLEAN:
                                System.out.print(cell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                System.out.print(df.format(cell.getNumericCellValue()));
                                break;
                            case BLANK:
                                System.out.print("");
                                break;
                            default:
                                System.out.print("");
                        }*/
                            }
                            //System.out.print(cellReference.formatAsString());
                            //System.out.print(row.getRowNum());
                            //System.out.print(cell.getColumnIndex());
                    /*String text = formatter.formatCellValue(cell);
                    System.out.print(text);*/
                            //cell.getCellTypeEnum()
                    /*switch ( evaluator.evaluateInCell(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getRichStringCellValue().getString());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue().toLocaleString());
                            } else {
                                System.out.print(cell.getNumericCellValue());
                            }
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            System.out.print("error");
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            System.out.print("");
                            break;
                    }*/
                        }
                        n++;
                    }
                }


            }
            Configuration conf = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

            Session sess = sf.openSession();
            Transaction tx = sess.beginTransaction();
            for (int i=0; i<n; i++){
               /*System.out.println(test[i].getName() + ":" + test[i].getSalary()
                        + ":" + test[i].getBasicSalary() + ":" + test[i].getCheckSalary() + ":" + test[i].getFloatingSalary());*/
               test[i].getSalary().setEid(i);
               test[i].getSalary().setDate(new Date());
               sess.save(test[i]);

            }
            tx.commit();
            sess.close();
            sf.close();
            System.out.println(JsonUtil.toJson(test));
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}
