package com.runfeng.struts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.hibernate.HqlQuery;
import com.runfeng.utils.EmployeeInfoExcelTableParseUtil;
import com.runfeng.utils.JsonUtil;

/**
 * Created by lenovo on 2017/3/31.
 */
public class InfoTableAction extends ActionSupport {
    private String employeesInfo;
    private String department;
    private String infoType;

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

    public String getEmployeesInfo() {
        return employeesInfo;
    }

    public void setEmployeesInfo(String employeesInfo) {
        this.employeesInfo = employeesInfo;
    }

    public String execute(){
        employeesInfo = HqlQuery.findEmployeeInfo();//JsonUtil.toJson(EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null).values());
        return Action.SUCCESS;
    }
}
