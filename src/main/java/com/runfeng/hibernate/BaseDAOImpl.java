package com.runfeng.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

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
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
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
        String hql = "select en from " + entityClz.getSimpleName() + " en";
        return (List<T>)find(hql);
    }

    @Override
    public long findCount(Class<T> entityClz) {
        List l = find("select count(*) from " + entityClz.getSimpleName());
        if (l != null && l.size() == 1){
            return (int)l.get(0);
        }
        return 0;
    }

    protected List find(String hql){
        return getSessionFactory().getCurrentSession()
                .createQuery(hql).list();
    }

    protected List find(String hql, Object... params){
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        for (int i=0; i<params.length; i++){
            query.setParameter(i + "", params[i]);
        }
        return query.list();
    }

    protected List findByPage(String hql, int pageNum, int pageSize){
        return getSessionFactory().getCurrentSession().createQuery(hql)
                .setFirstResult((pageNum-1) * pageSize)
                .setMaxResults(pageSize).list();
    }

    protected List findByPage(String hql, int pageNum, int pageSize, Object... params){
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        for (int i=0; i<params.length; i++){
            query.setParameter(i + "", params[i]);
        }
        return query.list();
    }

    /**
     * Created by hasee-pc on 2017/4/9.
     */
    public static class BasicInfoDAOImpl {
    }
}
