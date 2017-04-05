package com.runfeng.hibernate;

import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;
import com.runfeng.hibernate.InformationJson.ContractJson;
import com.runfeng.hibernate.InformationJson.EducationJson;
import com.runfeng.hibernate.InformationJson.PositionInfoJson;
import com.runfeng.utils.DepartmentParseUtil;
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
import com.runfeng.utils.*;
/**
 * Created by 帝 on 2017/3/31.
 */
public class HqlQuery {
    public static String findEmployeeInfo(String department){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List<PersonalInfo> infoList = null;
        if (department.equals("all")){
            infoList = sess.createQuery("select distinct pi from PersonalInfo pi").list();
        }else{
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            infoList = sess.createQuery("select distinct pi from PersonalInfo pi " +
                    "where pi.positionInfo.department = :department")
                    .setString("department", department_zh_CN).list();
        }


        List<EmployeeInfo> infoTransferList = new ArrayList<>();
        for (Iterator<PersonalInfo> it = infoList.iterator(); it.hasNext();){
            PersonalInfo temp = it.next();
            infoTransferList.add(new EmployeeInfo(temp.getMainID(), temp.getBasicInfo(), temp.getPositionInfo(), temp.getContract(), temp.getEducation()));

        }
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(infoTransferList);
    }

    public static String findPositionInfo(){
        Session sess = HqlUtil.currentSession();
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
        /*List<PositionInfo> infoTransferList = new ArrayList<>();
        for (Iterator it = infoList.iterator(); it.hasNext();){
            PersonalInfo temp = it.next();
            infoTransferList.add();

        }*/
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(positionJson);
    }

    public static String findEducationInfo(){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List infoList = sess.createQuery("select distinct pi.mainID, pi.education from PersonalInfo pi").list();
        List<EducationJson> educationJsons = new ArrayList<>();
        MainID temp_MainID;
        Education temp_PositionInfo;
        for (Iterator it = infoList.iterator(); it.hasNext();){
            Object[] objects = (Object[])it.next();
            temp_MainID = (MainID)objects[0];
            temp_PositionInfo = (Education)objects[1];
            educationJsons.add(new EducationJson(temp_MainID, temp_PositionInfo));
        }
        /*List<PositionInfo> infoTransferList = new ArrayList<>();
        for (Iterator it = infoList.iterator(); it.hasNext();){
            PersonalInfo temp = it.next();
            infoTransferList.add();

        }*/
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(educationJsons);

    }

    public static String findContractInfo(){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List infoList = sess.createQuery("select distinct pi.mainID, pi.contract from PersonalInfo pi").list();
        List<ContractJson> contractJsons = new ArrayList<>();
        MainID temp_MainID;
        Contract temp_Contract;
        for (Iterator it = infoList.iterator(); it.hasNext();){
            Object[] objects = (Object[])it.next();
            temp_MainID = (MainID)objects[0];
            temp_Contract = (Contract)objects[1];
            contractJsons.add(new ContractJson(temp_MainID, temp_Contract));
        }
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(contractJsons);

    }
    public static String findBasicInfo(){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List infoList = sess.createQuery("select distinct pi.mainID, pi.basicInfo from PersonalInfo pi").list();
        List<BasicInfoJson> basicInfoJsons = new ArrayList<>();
        MainID temp_MainID;
        BasicInfo temp_BasicInfo;
        for (Iterator it = infoList.iterator(); it.hasNext();){
            Object[] objects = (Object[])it.next();
            temp_MainID = (MainID)objects[0];
            temp_BasicInfo = (BasicInfo)objects[1];
            basicInfoJsons.add(new BasicInfoJson(temp_MainID, temp_BasicInfo));
        }
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(basicInfoJsons);
    }
    public static String findSalary(){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List salary = sess.createQuery("select distinct s from Salary s").list();
        //System.out.println();
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(salary);
    }
}
