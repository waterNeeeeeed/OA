package com.runfeng.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by 帝 on 2017/2/27.
 */
public class NewsManager {
    public static void main(String[] args){
        Configuration conf = new Configuration().configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        News n = new News();
        n.setTitle("hello world");
        n.setContent("i come here!!!");
        sess.save(n);
        tx.commit();
        sess.close();
        sf.close();
    }
}
