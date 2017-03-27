package com.runfeng.struts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lenovo on 2017/3/27.
 */
public class SalaryTableAction extends ActionSupport {
    private String department;
    private String salaryType;

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

    @Override
    public String execute(){
        if (salaryType == "component" && department == "all"){

        }
        return null;
    }
}
