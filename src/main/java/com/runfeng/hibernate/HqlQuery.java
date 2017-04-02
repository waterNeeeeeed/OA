package com.runfeng.hibernate;

import com.runfeng.hibernate.InformationEntity.EmployeeInfo;
import com.runfeng.utils.JsonUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 帝 on 2017/3/31.
 */
public class HqlQuery {
    public static String findEmployeeInfo(){
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        List employeesInfo = sess.createQuery("select distinct e from EmployeeInfo e").list();
        //System.out.println();
        tx.commit();
        sess.close();
        sf.close();
        return JsonUtil.toJson(employeesInfo);
    }
    public static String findSalary(){
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        List salary = sess.createQuery("select distinct s from Salary s").list();
        //System.out.println();
        tx.commit();
        sess.close();
        sf.close();
        return JsonUtil.toJson(salary);
    }
}
