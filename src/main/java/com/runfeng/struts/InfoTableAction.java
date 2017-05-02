package com.runfeng.struts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.hibernate.HqlQuery;
import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.*;
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

    private String modifyType;
    private String modifyEid;
    private String modifyContent;
    private String modifyResult;
    private final String MODIFY_SUCCESS = "modify_success";

    private String numberOfEmployees;

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

    public String getModifyResult() {
        return modifyResult;
    }

    public void setModifyResult(String modifyResult) {
        this.modifyResult = modifyResult;
    }

    public String getModifyContent() {
        return modifyContent;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    public String getModifyEid() {
        return modifyEid;
    }

    public void setModifyEid(String modifyEid) {
        this.modifyEid = modifyEid;
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
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

    public String modify(){
        /*根据类型和ＥＩＤ修改信息*/
        personalInfoService.updatePersonalInfo(getModifyType(),Integer.parseInt(getModifyEid()),getModifyContent());
        /*修改成功*/
        setModifyResult(MODIFY_SUCCESS);
        return Action.SUCCESS;
    }

    public String execute(){
        /*获取部门汉语*/
        department_zh_CN = DepartmentParseUtil.departmentParse(department);
        /*获取分部门分类型信息表头*/
        informationTableHead = personalInfoService.findPersonInfoTableHead(department, getInfoType());
        /*获取分部门分类型信息表*/
        employeesInfo = personalInfoService.findPersonInfo(department, getInfoType());

        return Action.SUCCESS;
    }
}
