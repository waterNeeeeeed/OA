package com.runfeng.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 帝 on 2017/2/23.
 */
public class LoginAction extends ActionSupport
    implements ServletResponseAware{
    private String user;
    private String pass;
    private String tip;
    private HttpServletResponse responseAware;

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
        ActionContext actx = ActionContext.getContext();
        Integer counter;

        counter = (Integer)actx.getApplication().get("counter");
        if (null == counter){
            counter = 1;
        }else {
            counter++;
        }
        actx.getApplication().put("counter", counter);
        actx.getSession().put("user", getUser());

        if (getUser().equals("gongtao") && getPass().equals("123")){
            actx.put("tip", "Server:login successful");
            Cookie cookie = new Cookie("user", getUser());
            cookie.setMaxAge(60 * 60);
            responseAware.addCookie(cookie);
            /*setUser(null);
            setPass(null);*/
            return SUCCESS;
        }

        actx.put("tip", "Server:login failed");
        return ERROR;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.responseAware = httpServletResponse;
    }
}
