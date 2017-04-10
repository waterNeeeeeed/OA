package com.runfeng.spring.service.InformationService;

import com.runfeng.hibernate.InformationEntity.CasualWorker;
import com.runfeng.hibernate.Page;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public interface CasualWorkerService {
    void addCasualWorker(CasualWorker casualWorker);
    void addCasualWorkerList(List<CasualWorker> casualWorkerList);
    void deleteCasualWorker(CasualWorker casualWorker);
    CasualWorker queryCasualWorker(String identification);
    List<CasualWorker> queryCasualWorkerList(Page page);
    List<CasualWorker> queryCasualWorkerByName(String Name);

}
