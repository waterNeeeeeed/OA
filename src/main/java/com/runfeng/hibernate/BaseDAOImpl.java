package com.runfeng.hibernate;

import com.runfeng.hibernate.BaseDAO;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class BaseDAOImpl<T> implements BaseDAO<T>{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T get(Class<T> entityClz, Serializable id) {
        return (T) getSessionFactory().getCurrentSession().get(entityClz, id);
    }

    @Override
    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSessionFactory().getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Class<T> entityClz, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClz.getSimpleName() + " en where en.id = ?0")
                .setParameter("0", id)
                .executeUpdate();
    }

    @Override
    public List<T> findAll(Class<T> entityClz) {
        return null;
    }

    @Override
    public long findCount(Class<T> entityClz) {
        return 0;
    }

    public List<T> findByPage(String hql, int pageNum, int pageSize){
        return null;
    }
}
