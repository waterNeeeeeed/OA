package com.runfeng.hibernate;

import com.runfeng.hibernate.InformationEntity.EmployeeInfo;
import com.runfeng.hibernate.InformationEntity.MainID;
import com.runfeng.hibernate.InformationEntity.PersonalInfo;
import com.runfeng.hibernate.InformationEntity.PositionInfo;
import com.runfeng.hibernate.InformationJson.PositionInfoJson;
import com.runfeng.utils.JsonUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Iterator;
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
        List<PersonalInfo> infoList = sess.createQuery("select distinct pi from PersonalInfo pi").list();

        List<EmployeeInfo> infoTransferList = new ArrayList<>();
        for (Iterator<PersonalInfo> it = infoList.iterator(); it.hasNext();){
            PersonalInfo temp = it.next();
            infoTransferList.add(new EmployeeInfo(temp.getMainID(), temp.getBasicInfo(), temp.getPositionInfo(), temp.getContract(), temp.getEducation()));

        }
        tx.commit();
        sess.close();
        sf.close();
        return JsonUtil.toJson(infoTransferList);
    }

    public static String findPositionInfo(){
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        List infoList = sess.createQuery("select distinct pi.mainID, pi.positionInfo from PersonalInfo pi").list();
        List<PositionInfoJson> positionJson = new ArrayList<>();
        MainID temp_MainID;
        PositionInfo temp_PositionInfo;
        for (Iterator it = infoList.iterator(); it.hasNext();){
            Object[] objects = (Object[])it.next();
            temp_MainID = (MainID)objects[0];
            temp_PositionInfo = (PositionInfo)objects[1];
            positionJson.add(new PositionInfoJson(temp_MainID, temp_PositionInfo));
        }
        System.out.print("");
        /*List<PositionInfo> infoTransferList = new ArrayList<>();
        for (Iterator it = infoList.iterator(); it.hasNext();){
            PersonalInfo temp = it.next();
            infoTransferList.add();

        }*/
        tx.commit();
        sess.close();
        sf.close();
        return JsonUtil.toJson(positionJson);
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
