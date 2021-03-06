package com.runfeng.hibernate;

import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;
import com.runfeng.hibernate.InformationJson.ContractJson;
import com.runfeng.hibernate.InformationJson.EducationJson;
import com.runfeng.hibernate.InformationJson.PositionInfoJson;
import com.runfeng.utils.DepartmentParseUtil;
import com.runfeng.utils.JsonUtil;
import org.apache.struts2.json.annotations.JSON;
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
    public static List queryEntity(Session session, String department, StringBuffer hql){
        List infoList;
        if (department.equals("all")){
            infoList = (List<PersonalInfo>)session.createQuery(hql.toString()).list();
        }else{
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            hql.append("where pi.positionInfo.department = :department");
            infoList = session.createQuery(hql.toString())
                    .setString("department", department_zh_CN).list();
        }
        return infoList;
    }

    //所有信息整合后的信息
    public static String findEmployeeInfo(String department){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List<PersonalInfo> infoList;
        StringBuffer hql = new StringBuffer();
        hql.append("select distinct pi from PersonalInfo pi").append(" ");
        infoList = queryEntity(sess, department, hql);
        List<EmployeeInfo> infoTransferList = new ArrayList<>();
        for (Iterator<PersonalInfo> it = infoList.iterator(); it.hasNext();){
            PersonalInfo temp = it.next();
            infoTransferList.add(new EmployeeInfo(temp.getMainID(), temp.getBasicInfo(), temp.getPositionInfo(), temp.getContract(), temp.getEducation()));

        }
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(infoTransferList);
    }

    //职位信息
    public static String findPositionInfo(String department){
        return JsonUtil.toJson(queryPositionInfo(department));
    }

    public static List<PositionInfoJson> queryPositionInfo(String department){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        //List infoList = sess.createQuery("select distinct pi.mainID, pi.positionInfo from PersonalInfo pi").list();
        StringBuffer hql = new StringBuffer();
        hql.append("select distinct pi.mainID, pi.positionInfo from PersonalInfo pi").append(" ");
        List infoList = queryEntity(sess, department, hql);

        List<PositionInfoJson> positionJson = new ArrayList<>();
        MainID temp_MainID;
        PositionInfo temp_PositionInfo;
        for (Iterator it = infoList.iterator(); it.hasNext();){
            Object[] objects = (Object[])it.next();
            temp_MainID = (MainID)objects[0];
            temp_PositionInfo = (PositionInfo)objects[1];
            positionJson.add(new PositionInfoJson(temp_MainID, temp_PositionInfo));
        }
        tx.commit();
        HqlUtil.closeSession();
        return positionJson;
    }

    //教育信息
    public static String findEducationInfo(String department){
        return JsonUtil.toJson(queryEducationInfo(department));
    }
    public static List<EducationJson> queryEducationInfo(String department){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        StringBuffer hql = new StringBuffer().append("select distinct pi.mainID, pi.education from PersonalInfo pi")
                            .append(" ");
        List infoList = queryEntity(sess, department, hql);

        List<EducationJson> educationJsons = new ArrayList<>();
        MainID temp_MainID;
        Education temp_PositionInfo;
        for (Iterator it = infoList.iterator(); it.hasNext();){
            Object[] objects = (Object[])it.next();
            temp_MainID = (MainID)objects[0];
            temp_PositionInfo = (Education)objects[1];
            educationJsons.add(new EducationJson(temp_MainID, temp_PositionInfo));
        }
        tx.commit();
        HqlUtil.closeSession();
        return educationJsons;

    }

    //合同信息
    public static String findContractInfo(String department){
        return JsonUtil.toJson(queryContractInfo(department));
    }
    public static List<ContractJson> queryContractInfo(String department){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        StringBuffer hql = new StringBuffer().append("select distinct pi.mainID, pi.contract from PersonalInfo pi")
                            .append(" ");
        List infoList = queryEntity(sess, department, hql);

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
        return contractJsons;

    }

    //基本信息
    public static String findBasicInfo(String department){
        return JsonUtil.toJson(queryBasicInfoList(department));
    }

    public static List<BasicInfoJson> queryBasicInfoList(String department){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        //List infoList = sess.createQuery("select distinct pi.mainID, pi.basicInfo from PersonalInfo pi").list();
        StringBuffer hql = new StringBuffer();
        hql.append("select distinct pi.mainID, pi.basicInfo from PersonalInfo pi").append(" ");
        List infoList = queryEntity(sess, department, hql);

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
        return basicInfoJsons;
    }

    public static String findSalary(){
        Session sess = HqlUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        List salary = sess.createQuery("select distinct s from Salary s").list();
        tx.commit();
        HqlUtil.closeSession();
        return JsonUtil.toJson(salary);
    }
}
