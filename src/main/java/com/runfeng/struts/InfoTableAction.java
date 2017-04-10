package com.runfeng.struts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.hibernate.HqlQuery;
import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.BasicInfoHead;
import com.runfeng.hibernate.InformationJson.ContractHead;
import com.runfeng.hibernate.InformationJson.EducationHead;
import com.runfeng.hibernate.InformationJson.PositionInfoHead;
import com.runfeng.spring.service.InformationService.PersonalInfoService;
import com.runfeng.utils.DepartmentParseUtil;
import com.runfeng.utils.JsonUtil;
import com.runfeng.utils.TableHeadParseUtil;

/**
 * Created by lenovo on 2017/3/31.
 */
public class InfoTableAction extends ActionSupport {
    private String employeesInfo;
    private String informationTableHead;
    private String department;
    private String department_zh_CN;
    private String infoType;

    //????????????????????????????????
    //可以有set但不能有get，应为使用strust2 json插件，会把这个也转化，造成问题。
    //如果序列化的话呢？
    private PersonalInfoService personalInfoService;

    /*public PersonalInfoService getPersonalInfoService() {
        return personalInfoService;
    }*/

    public void setPersonalInfoService(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    public String getDepartment_zh_CN() {
        return department_zh_CN;
    }

    public void setDepartment_zh_CN(String department_zh_CN) {
        this.department_zh_CN = department_zh_CN;
    }

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

    /*//基本信息表头
    public String convertEmployeesInfoHeadToJson(){
        EmployeesInfoHead sth = new EmployeesInfoHead("EID", "姓名", "性别", "身份证号",
                "手机号码", "籍贯", "工号", "部门",
                "岗位", "职务", "职务状态",
                "学历", "学校", "办学形式", "主修",
                "合同编号", "第一次签合同","合同起始", "合同终止", "合同状态");
        return JsonUtil.toJson(sth);
    }*/
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

    //basic basicInfo position education contract
    public String execute(){
        /*ActionContext actx = ActionContext.getContext();
        actx.getSession().put("department_zh_CN", DepartmentParseUtil.departmentParse(department));*/
        department_zh_CN = DepartmentParseUtil.departmentParse(department);

        if (getInfoType().equals("basic")){
            informationTableHead = TableHeadParseUtil.convertTableHeadToJson("tablehead/employeesinfo_tablehead",
                    "com.runfeng.hibernate.InformationEntity.EmployeesInfoHead");
            employeesInfo = personalInfoService.findEmployeeInfo(getDepartment());
        }
        if (infoType.equals("basicInfo")){
            informationTableHead = convertBasicInfoHeadToJson();
            /*employeesInfo = HqlQuery.findBasicInfo(getDepartment());*/
            employeesInfo = personalInfoService.findBasicInfo(getDepartment());
            //System.out.print(employeesInfo);
        }
        if (infoType.equals("position")){
            informationTableHead = convertPositionHeadToJson();
            employeesInfo = personalInfoService.findPositionInfo(getDepartment());
        }
        if (infoType.equals("education")){
            informationTableHead = convertEducationHeadToJson();
            employeesInfo = personalInfoService.findEducationInfo(getDepartment());
        }

        if (infoType.equals("contract")){
            informationTableHead = convertContractHeadToJson();
            employeesInfo = personalInfoService.findContractInfo(getDepartment());
        }
        //JsonUtil.toJson(EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null).values());
        System.out.println(employeesInfo);
        return Action.SUCCESS;
    }
}
