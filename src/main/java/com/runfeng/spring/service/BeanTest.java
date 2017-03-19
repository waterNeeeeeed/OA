package com.runfeng.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 帝 on 2017/2/20.
 */
public class BeanTest {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-constructor.xml");
        Person p = ctx.getBean("chinese", Person.class);

        p.useAxe();
    }
}
