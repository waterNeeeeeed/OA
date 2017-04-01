package com.runfeng.utils;

import com.runfeng.hibernate.Salary.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2017/4/1.
 */
public class SalaryExcelTableParseUtilTest {
    @Test
    public void inputSalary() throws Exception {
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hqlDelete = "delete Salary";
        sess.createQuery(hqlDelete).executeUpdate();
        List<Salary> salaryList = SalaryExcelTableParseUtil.inputSalary();

        for (Iterator<Salary> it = salaryList.iterator(); it.hasNext(); ) {
            sess.save(it.next());
        }
        tx.commit();
        sess.close();
        sf.close();
    }

}