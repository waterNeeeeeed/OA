package com.runfeng.struts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.hibernate.HqlQuery;
import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.BasicInfoHead;
import com.runfeng.hibernate.InformationJson.ContractHead;
import com.runfeng.hibernate.InformationJson.EducationHead;
import com.runfeng.hibernate.InformationJson.PositionInfoHead;
import com.runfeng.utils.JsonUtil;

/**
 * Created by lenovo on 2017/3/31.
 */
public class InfoTableAction extends ActionSupport {
    private String employeesInfo;
    private String informationTableHead;
    private String department;
    private String infoType;

    public String getEmployeesInfo() {
        return employeesInfo;
    }

    public void setEmployeesInfo(String employeesInfo) {
        this.employeesInfo = employeesInfo;
    }

    public String getInformationTableHead() {
        return informationTableHead;
    }

    public void setInformationTableHead(String informationTableHead) {
        this.informationTableHead = informationTableHead;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    //基本信息表头
    public String convertEmployeesInfoHeadToJson(){
        EmployeesInfoHead sth = new EmployeesInfoHead("EID", "姓名", "性别", "身份证号",
                "手机号码", "籍贯", "工号", "部门",
                "岗位", "职务", "职务状态",
                "学历", "学校", "办学形式", "主修",
                "合同编号", "合同起始", "合同终止", "合同状态");
        return JsonUtil.toJson(sth);
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
                "合同编号", "合同起始", "合同终止","合同状态");
        return JsonUtil.toJson(contractHead);
    }

    //basic basicInfo position education contract
    public String execute(){
        if (department.equals("all") && infoType.equals("basic")){
            informationTableHead = convertEmployeesInfoHeadToJson();
            employeesInfo = HqlQuery.findEmployeeInfo();
        }
        if (department.equals("all") && infoType.equals("basicInfo")){
            informationTableHead = convertBasicInfoHeadToJson();
            employeesInfo = HqlQuery.findBasicInfo();
        }
        if (department.equals("all") && infoType.equals("position")){
            informationTableHead = convertPositionHeadToJson();
            employeesInfo = HqlQuery.findPositionInfo();
        }
        if (department.equals("all") && infoType.equals("education")){
            informationTableHead = convertEducationHeadToJson();
            employeesInfo = HqlQuery.findEducationInfo();
        }

        if (department.equals("all") && infoType.equals("contract")){
            informationTableHead = convertContractHeadToJson();
            employeesInfo = HqlQuery.findContractInfo();
        }
        //JsonUtil.toJson(EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null).values());
        //System.out.println(employeesInfo);
        return Action.SUCCESS;
    }
}
