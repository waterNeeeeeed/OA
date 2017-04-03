package com.runfeng.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

/**
 * Created by lenovo on 2017/3/21.
 */
public class ManageAction extends ActionSupport {
    private String salaryType;
    private String infoType;
    private String department;

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

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }


    public String SalaryManage(){
        ActionContext ctx = ActionContext.getContext();
        ctx.getSession().put("salaryType", getSalaryType());
        return "SalaryManage";
    }

    public String InformationManage(){
        ActionContext.getContext().getSession().put("infoType", getInfoType());
        ActionContext.getContext().getSession().put("department", getDepartment());
        return "InformationManage";
    }

    public String ExitAction(){
        ActionContext ctx = ActionContext.getContext();
        ctx.getSession().put("user", null);
        return "ExitAction";
    }
    public String execute(){
        return null;
    }
}
