package com.runfeng.struts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
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
import java.util.Date;

/**
 * Created by lenovo on 2017/3/27.
 */
public class SalaryTableAction extends ActionSupport {
    private String department;
    private String salaryType;
    private String test;
    private Salary[] salary;


    public Salary[] getSalary() {
        return salary;
    }

    public void setSalary(Salary[] salary) {
        this.salary = salary;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    @Override
    public String execute(){
        test = "only for love";
        if (department.equals("all") && salaryType.equals("component")){
            test = "only for make love";
        }
        try {
            Workbook wb = WorkbookFactory.create(new File("2017.xls"));
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = wb.getSheetAt(0);
            DecimalFormat df   = new DecimalFormat("######0.00");

            salary = new Salary[1000];
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
            /*Configuration conf = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

            Session sess = sf.openSession();
            Transaction tx = sess.beginTransaction();*/
            for (int i=0; i<n; i++){
                salary[i].setEid(i);
                salary[i].setDate(new Date());
                /*sess.save(test[i]);*/
            }
            /*tx.commit();
            sess.close();
            sf.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return Action.SUCCESS;
    }
}
