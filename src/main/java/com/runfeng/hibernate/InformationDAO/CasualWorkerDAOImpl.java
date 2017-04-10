package com.runfeng.hibernate.InformationDAO;

import com.runfeng.hibernate.BaseDAOImpl;
import com.runfeng.hibernate.InformationEntity.CasualWorker;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class CasualWorkerDAOImpl extends BaseDAOImpl<CasualWorker>
        implements CasualWorkerDAO {

    @Override
    public List<CasualWorker> findCasualWorkerByPage(int pageNum, int pageSize) {
        String hql = "select * from " + CasualWorker.class.getSimpleName();
        return findByPage(hql, pageNum, pageSize);
    }
}
