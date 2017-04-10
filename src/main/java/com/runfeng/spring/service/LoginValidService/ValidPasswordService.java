package com.runfeng.spring.service.LoginValidService;

/**
 * Created by 帝 on 2017/4/5.
 */
public class ValidPasswordService {
    public boolean validPassword(String user, String password){
        if (user.equals("gongtao") && password.equals("123")){
            return true;
        }
        return false;
    }
}
