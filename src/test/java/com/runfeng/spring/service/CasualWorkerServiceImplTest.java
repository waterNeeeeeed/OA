package com.runfeng.spring.service;

import com.runfeng.hibernate.InformationEntity.CasualWorker;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class CasualWorkerServiceImplTest {
    private ApplicationContext applicationContext;
    private CasualWorkerService casualWorkerService;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("HibernateSpring.xml");
        casualWorkerService = applicationContext.getBean("casualWorkerService", CasualWorkerService.class);
    }

    @Test
    public void getCasualWorkerDAO() throws Exception {

    }

    @Test
    public void setCasualWorkerDAO() throws Exception {

    }

    @Test
    public void addCasualWorker() throws Exception {
        CasualWorker casualWorker = new CasualWorker("gongtao", "男", 30, "370783198708256132",
                "15953680098", "滨海");
        casualWorkerService.addCasualWorker(casualWorker);
    }

    @Test
    public void addCasualWorkerList() throws Exception {

    }

    @Test
    public void deleteCasualWorker() throws Exception {
        CasualWorker casualWorker = new CasualWorker("gongtao", "男", 30, "370783198708256132",
                "15953680098", "滨海");
        casualWorkerService.deleteCasualWorker(casualWorker);
    }

    @Test
    public void queryCasualWorker() throws Exception {

    }

    @Test
    public void queryCasualWorker1() throws Exception {

    }

    @Test
    public void queryCasualWorkerByName() throws Exception {

    }

}