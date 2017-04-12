package com.runfeng.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by 帝 on 2017/4/3.
 */
public class HqlUtil {
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> session = new ThreadLocal<>();
    static {
        try{
            Configuration conf = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Session currentSession(){
        Session s = session.get();
        if (s == null){
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession(){
        Session s = session.get();
        if (s != null){
            s.close();
        }
        session.set(null);
    }
}
