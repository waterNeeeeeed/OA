package com.runfeng.spring.service.InformationService;

import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.*;
import com.runfeng.hibernate.InformationDAO.PersonalInfoDAO;
import com.runfeng.utils.DepartmentParseUtil;
import com.runfeng.utils.JsonUtil;
import com.runfeng.utils.TableHeadParseUtil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    @Override
    public String findPersonInfo(String department, String infoType) {
        String employeesInfo = "";
        if (infoType.equals("basic")){
            employeesInfo = findEmployeeInfo(department);
        }
        if (infoType.equals("basicInfo")){
            employeesInfo = findBasicInfo(department);
        }
        if (infoType.equals("position")){
            employeesInfo = findPositionInfo(department);
        }
        if (infoType.equals("education")){
            employeesInfo = findEducationInfo(department);
        }

        if (infoType.equals("contract")){
            employeesInfo = findContractInfo(department);
        }
        return employeesInfo;
    }

    //个人信息表头
    public String convertBasicInfoHeadToJson(){
        BasicInfoHead basicInfoHead = new BasicInfoHead("EID", "姓名", "性别",
                "身份证号码", "手机", "籍贯");
        return JsonUtil.toJson(basicInfoHead);
    }

    //岗位信息表头
    public String convertPositionHeadToJson(){
        PositionInfoHead positionInfoHead = new PositionInfoHead("EID", "姓名","工号", "部门",
                "岗位", "职务","岗位状态");
        return JsonUtil.toJson(positionInfoHead);
    }
    //教育信息表头
    public String convertEducationHeadToJson(){
        EducationHead educationHead = new EducationHead("EID", "姓名",
                "学历", "学校", "学习形式","主修");
        return JsonUtil.toJson(educationHead);
    }
    //合同信息表头
    public String convertContractHeadToJson(){
        ContractHead contractHead = new ContractHead("EID", "姓名",
                "合同编号",  "第一次签合同","合同起始", "合同终止","合同状态");
        return JsonUtil.toJson(contractHead);
    }
    @Override
    public String findPersonInfoTableHead(String department, String infoType) {
        String informationTableHead = "";
        if (infoType.equals("basic")){
            informationTableHead = TableHeadParseUtil.convertTableHeadToJson("tablehead/employeesinfo_tablehead",
                    "com.runfeng.hibernate.InformationEntity.EmployeesInfoHead");
        }
        if (infoType.equals("basicInfo")){
            informationTableHead = convertBasicInfoHeadToJson();
        }
        if (infoType.equals("position")){
            informationTableHead = convertPositionHeadToJson();
        }
        if (infoType.equals("education")){
            informationTableHead = convertEducationHeadToJson();
        }

        if (infoType.equals("contract")){
            informationTableHead = convertContractHeadToJson();
        }
        return informationTableHead;
    }
    @Override
    public String findNumberOfEmployees() {
        List<NumberOfEmployees> list = personalInfoJsonFactory.createInfoJsonList();
        List<String> ContractstateList = (List<String>)personalInfoDAO.findAllContractstate();
        int n = 0;
        for(Iterator it=ContractstateList.iterator(); it.hasNext();){
            String state = (String)it.next();
            long num = personalInfoDAO.findContractstateCount(state);
            NumberOfEmployees numberOfEmployees = new NumberOfEmployees(n++, state, (int)num);
            list.add(numberOfEmployees);
        }
        return JsonUtil.toJson(list);
    }



    @Override
    public void updatePersonalInfo(String modifyType, int eid, String entityJson) {
        if (modifyType.equals("basicInfo")){
            personalInfoDAO.updatePersonInfoBasicInfo(eid,
                    JsonUtil.fromJson(entityJson, BasicInfoJson.class));
        }
        if (modifyType.equals("position")){
            personalInfoDAO.updatePersonInfoPositionInfo(eid,
                    JsonUtil.fromJson(entityJson, PositionInfoJson.class));
        }
        if (modifyType.equals("education")){
            personalInfoDAO.updatePersonInfoEducationInfo(eid,
                    JsonUtil.fromJson(entityJson, EducationJson.class));
        }
        if (modifyType.equals("contract")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            personalInfoDAO.updatePersonInfoContractInfo(eid,
                    JsonUtil.fromJson(entityJson, ContractJson.class));
        }
    }
}
