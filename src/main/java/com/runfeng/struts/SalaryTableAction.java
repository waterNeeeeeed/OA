package com.runfeng.struts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.hibernate.HqlQuery;
import com.runfeng.hibernate.SalaryEntity.SalaryTableHead;
import com.runfeng.utils.JsonUtil;

/**
 * Created by lenovo on 2017/3/27.
 */
public class SalaryTableAction extends ActionSupport {
    private String department;
    private String salaryType;
    private String employeesSalary;
    private String salaryTableHead;

    public String getSalaryTableHead() {
        return salaryTableHead;
    }

    public void setSalaryTableHead(String salaryTableHead) {
        this.salaryTableHead = salaryTableHead;
    }

    public String getEmployeesSalary() {
        return employeesSalary;
    }

    public void setEmployeesSalary(String employeesSalary) {
        this.employeesSalary = employeesSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String convertTableHeadToJson(){
        SalaryTableHead sth = new SalaryTableHead("EID", "姓名", "部门", "日期",
                "应发工资", "基本工资", "考核工资", "浮动工资",
                "节日", "假日", "夜班费", "保健、补助",
                "合计");
        return JsonUtil.toJson(sth);
    }

    public String fillTableContent(){
        return null;
    }

    @Override
    public String execute(){

        employeesSalary = HqlQuery.findSalary();
        salaryTableHead = convertTableHeadToJson();
        return Action.SUCCESS;
    }
}
