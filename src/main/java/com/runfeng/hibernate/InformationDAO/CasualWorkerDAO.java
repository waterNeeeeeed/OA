package com.runfeng.hibernate.InformationDAO;

import com.runfeng.hibernate.BaseDAO;
import com.runfeng.hibernate.InformationEntity.CasualWorker;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public interface CasualWorkerDAO extends BaseDAO<CasualWorker> {
    List<CasualWorker> findCasualWorkerByPage(int pageNum, int pageSize);
}
