package com.runfeng.spring.service.InformationService;

import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.*;
import com.runfeng.hibernate.InformationDAO.PersonalInfoDAO;
import com.runfeng.utils.DepartmentParseUtil;
import com.runfeng.utils.JsonUtil;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private PersonalInfoDAO personalInfoDAO;
    private PersonalInfoJsonFactory personalInfoJsonFactory;

    public PersonalInfoJsonFactory getPersonalInfoJsonFactory() {
        return personalInfoJsonFactory;
    }

    public void setPersonalInfoJsonFactory(PersonalInfoJsonFactory personalInfoJsonFactory) {
        this.personalInfoJsonFactory = personalInfoJsonFactory;
    }

    public PersonalInfoDAO getPersonalInfoDAO() {
        return personalInfoDAO;
    }

    public void setPersonalInfoDAO(PersonalInfoDAO personalInfoDAO) {
        this.personalInfoDAO = personalInfoDAO;
    }


    private<T> List<T> createBIJ(List srcList, List objList, Class<T> Clz){
        for (Iterator it=srcList.iterator(); it.hasNext(); ){
            Object[] objects = (Object[])it.next();
            MainID mainID = (MainID)objects[0];
            /*BasicInfo basicInfo = (BasicInfo)objects[1];*/
            objList.add(personalInfoJsonFactory.create(mainID, objects[1], Clz));
        }
        return objList;
    }

    /********BasicInfo***************/
    @Override
    public String findBasicInfo(String department) {
        List srcList;
        if (department.equals("all")){
            srcList = personalInfoDAO.findAllBasicInfo();
        }else {
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            srcList = personalInfoDAO.findBasicInfoByDepartment(department_zh_CN);
        }
        List<BasicInfoJson> listBIJ = personalInfoJsonFactory.createInfoJsonList();

        return JsonUtil.toJson(createBIJ(srcList, listBIJ, BasicInfoJson.class));
    }

    /**/

    @Override
    public String findPositionInfo(String department) {
        List srcList;
        if (department.equals("all")){
            srcList = personalInfoDAO.findAllPositionInfo();
        }else {
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            srcList = personalInfoDAO.findPositionInfoByDepartment(department_zh_CN);
        }
        List<PositionInfoJson> listBIJ = personalInfoJsonFactory.createInfoJsonList();

        return JsonUtil.toJson(createBIJ(srcList, listBIJ, PositionInfoJson.class));
    }

    public String findEducationInfo(String department){
        List srcList;
        if (department.equals("all")){
            srcList = personalInfoDAO.findAllEducationInfo();
        }else {
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            srcList = personalInfoDAO.findEducationInfoByDepartment(department_zh_CN);
        }
        List<EducationJson> listBIJ = personalInfoJsonFactory.createInfoJsonList();

        return JsonUtil.toJson(createBIJ(srcList, listBIJ, EducationJson.class));
    }

    @Override
    public String findContractInfo(String department) {
        List srcList;
        if (department.equals("all")){
            srcList = personalInfoDAO.findAllContractInfo();
        }else {
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            srcList = personalInfoDAO.findContractInfoByDepartment(department_zh_CN);
        }
        List<ContractJson> listBIJ = personalInfoJsonFactory.createInfoJsonList();

        return JsonUtil.toJson(createBIJ(srcList, listBIJ, ContractJson.class));
    }

    /**/
    @Override
    public String findEmployeeInfo(String department){
        List srcList;
        if (department.equals("all")){
            srcList = personalInfoDAO.findAllEmployeeInfo();
        }else {
            String department_zh_CN = DepartmentParseUtil.departmentParse(department);
            srcList = personalInfoDAO.findEmployeeInfoByDepartment(department_zh_CN);
        }
        List<EmployeeInfo> objList = personalInfoJsonFactory.createInfoJsonList();
        for (Iterator it=srcList.iterator(); it.hasNext(); ){
            PersonalInfo personalInfo = (PersonalInfo)it.next();
            objList.add(personalInfoJsonFactory.createEmployeeInfo(personalInfo));
        }
        return JsonUtil.toJson(objList);
    }


}
