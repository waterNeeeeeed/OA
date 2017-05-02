package com.runfeng.spring.service;

import com.runfeng.spring.service.InformationService.CasualWorkerService;
import com.runfeng.spring.service.InformationService.PersonalInfoService;
import com.runfeng.spring.service.LoginValidService.ValidPasswordService;

/**
 * Created by lenovo on 2017/4/10.
 */
public class ServiceFactory {
    private PersonalInfoService personalInfoService;
    private CasualWorkerService casualWorkerService;
    private ValidPasswordService validPasswordService;

    public CasualWorkerService getCasualWorkerService() {
        return casualWorkerService;
    }

    public void setCasualWorkerService(CasualWorkerService casualWorkerService) {
        this.casualWorkerService = casualWorkerService;
    }

    public ValidPasswordService getValidPasswordService() {
        return validPasswordService;
    }

    public void setValidPasswordService(ValidPasswordService validPasswordService) {
        this.validPasswordService = validPasswordService;
    }

    public PersonalInfoService getPersonalInfoService() {
        return personalInfoService;
    }

    public void setPersonalInfoService(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }
}
