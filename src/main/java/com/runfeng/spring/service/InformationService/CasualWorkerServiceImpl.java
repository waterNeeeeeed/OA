package com.runfeng.spring.service.InformationService;

import com.runfeng.hibernate.InformationDAO.CasualWorkerDAO;
import com.runfeng.hibernate.InformationEntity.CasualWorker;
import com.runfeng.hibernate.Page;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class CasualWorkerServiceImpl implements CasualWorkerService {
    private CasualWorkerDAO casualWorkerDAO;

    public CasualWorkerDAO getCasualWorkerDAO() {
        return casualWorkerDAO;
    }

    public void setCasualWorkerDAO(CasualWorkerDAO casualWorkerDAO) {
        this.casualWorkerDAO = casualWorkerDAO;
    }

    @Override
    public void addCasualWorker(CasualWorker casualWorker) {
        casualWorkerDAO.save(casualWorker);
    }

    @Override
    public void addCasualWorkerList(List<CasualWorker> casualWorkerList) {

    }

    @Override
    public void deleteCasualWorker(CasualWorker casualWorker) {
        casualWorkerDAO.delete(CasualWorker.class, casualWorker.getIdentification());
    }
    

    @Override
    public CasualWorker queryCasualWorker(String identification) {
        return casualWorkerDAO.get(CasualWorker.class, identification);
    }

    @Override
    public List<CasualWorker> queryCasualWorkerList(Page page) {
        return casualWorkerDAO.findCasualWorkerByPage(page.getPageNum(), page.getPageSize());
    }

    @Override
    public List<CasualWorker> queryCasualWorkerByName(String Name) {
        return null;
    }
}
