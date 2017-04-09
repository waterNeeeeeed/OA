package com.runfeng.spring.service;

import com.runfeng.hibernate.InformationEntity.CasualWorker;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public interface CasualWorkerService {
    void addCasualWorker(CasualWorker casualWorker);
    void addCasualWorkerList(List<CasualWorker> casualWorkerList);
    void deleteCasualWorker(CasualWorker casualWorker);
    CasualWorker queryCasualWorker(String identification);
    List<CasualWorker> queryCasualWorker();
    List<CasualWorker> queryCasualWorkerByName(String Name);

}
