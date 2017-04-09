package com.runfeng.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public interface BaseDAO<T> {
    T get(Class<T> entityClz, Serializable id);
    Serializable save(T entity);
    void update(T entity);
    void delete(T entity);
    void delete(Class<T> entityClz, Serializable id);
    List<T> findAll(Class<T> entityClz);
    long findCount(Class<T> entityClz);
}
