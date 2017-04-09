package com.runfeng.hibernate;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class DAOFactory {
    public static CasualWorkerDAOImpl createCasualWorkerDAOImpl(){
        return new CasualWorkerDAOImpl();
    }
}
