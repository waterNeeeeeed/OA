package com.runfeng.struts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lenovo on 2017/3/21.
 */
public class ManageAction extends ActionSupport {
    public String SalaryManage(){
        return "SalaryManage";
    }

    public String InformationManage(){
        return "InformationManage";
    }

    public String execute(){
        return null;
    }
}
