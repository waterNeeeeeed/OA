package com.runfeng.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;

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

    public String ExitAction(){
        ActionContext ctx = ActionContext.getContext();
        ctx.getSession().put("user", null);
        return "ExitAction";
    }
    public String execute(){
        return null;
    }
}
