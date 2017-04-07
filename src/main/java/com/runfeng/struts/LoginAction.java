package com.runfeng.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.runfeng.spring.service.ValidPasswordService;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 帝 on 2017/2/23.
 */
public class LoginAction extends ActionSupport
    implements ServletResponseAware{
    private final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
    private String user;
    private String pass;
    private String tip;
    private HttpServletResponse responseAware;
    private ValidPasswordService vps;

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
        /*WebApplicationContext wactx = WebApplicationContextUtils.getWebApplicationContext(ser)
        ActionContext actx = ActionContext.getContext();
        Integer counter;*/

        /*counter = (Integer)actx.getApplication().get("counter");
        if (null == counter){
            counter = 1;
        }else {
            counter++;
        }
        actx.getApplication().put("counter", counter);
        actx.getSession().put("user", getUser());
*/
        LOGGER.info("用户:'" + getUser() + "'登录");
        if (vps.validPassword(getUser(), getPass())){
            /*actx.put("tip", "Server:login successful");*/
            Cookie cookie = new Cookie("user", getUser());
            cookie.setMaxAge(60 * 60);
            responseAware.addCookie(cookie);
            /*setUser(null);
            setPass(null);*/
            LOGGER.info("用户:'" + getUser() + "'登录成功!");
            return SUCCESS;
        }
/*
        actx.put("tip", "Server:login failed");*/
        return ERROR;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.responseAware = httpServletResponse;
    }
}
