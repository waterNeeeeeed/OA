package com.runfeng.spring.service.InformationService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hasee-pc on 2017/4/10.
 */
public class PersonalInfoServiceImplTest {
    private ApplicationContext applicationContext;
    private PersonalInfoService personalInfoService;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("HibernateSpring.xml");
        personalInfoService = applicationContext.getBean("personalInfoService", PersonalInfoService.class);
    }
    @Test
    public void findBasicInfo() throws Exception {
        System.out.println(personalInfoService.findBasicInfo("经理办"));
    }

}