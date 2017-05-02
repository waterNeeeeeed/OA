package com.runfeng.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.spring.service.LoginValidService.ValidPasswordService;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 帝 on 2017/2/23.
 */
public class LoginAction extends ActionSupport
    implements ServletResponseAware{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
    private String user;
    private String pass;
    private String tip;
    private HttpServletResponse responseAware;
    private ValidPasswordService vps;
    private ActionContext actionContext;

    public ActionContext getActionContext() {
        return actionContext;
    }

    public void setActionContext() {
        this.actionContext = ActionContext.getContext();
    }

    public ValidPasswordService getVps() {
        return vps;
    }

    public void setVps(ValidPasswordService vps) {
        this.vps = vps;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String execute(){
        setActionContext();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        LOGGER.info(sdf.format(new Date()) + "#" + "用户:'" + getUser() + "'登录");

        if (vps.validPassword(getUser(), getPass())){
            Cookie cookie = new Cookie("user", getUser());
            cookie.setMaxAge(60 * 60);
            responseAware.addCookie(cookie);
            getActionContext().getSession().put("user", getUser());

            LOGGER.info(sdf.format(new Date()) + "#" + "用户:'" + getUser() + "'登录成功!");
            getActionContext().getSession().put("tip", "登录成功!");
            return SUCCESS;
        }


        LOGGER.info(sdf.format(new Date()) + "#" + "用户:'" + getUser() + "'登录不成功，用户名或密码不正确!");
        getActionContext().getSession().put("tip", "用户名或密码不正确!");
        return ERROR;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.responseAware = httpServletResponse;
    }
}
