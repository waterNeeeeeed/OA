package com.runfeng.utils;

import com.runfeng.hibernate.EmployeeInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/3/31.
 */
public class EmployeeInfoExcelTableParseUtilTest {
    @Test
    public void inputEmployeeInfo() throws Exception {
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();

        Map<String, EmployeeInfo> employeeInfoMap = EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null);
        for (Map.Entry<String, EmployeeInfo> entry : employeeInfoMap.entrySet()){
            //System.out.println(JsonUtil.toJson(entry.getValue()));
            sess.save(entry.getValue());
        }
            /*employeeInfoMap
            for (int i=0; i<n; i++){
                salary[i].setEid(i);
                salary[i].setDate(new Date());
                *//**//*sess.save(test[i]);*//**//*
            }*/
            /*Salary[] salary2;
            salary2 = Arrays.copyOf(salary, n);
            employeesSalary = JsonUtil.toJson(salary2);
            salaryTableHead = convertTableHeadToJson();*/


        tx.commit();
        sess.close();
        sf.close();

    }

    @Test
    public void inputEmployeeInfo2() throws Exception {
        System.out.println(JsonUtil.toJson(EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null).values()));
    }

    @Test
    public void outputEmployeeInfoToExcel() throws Exception {

    }

}