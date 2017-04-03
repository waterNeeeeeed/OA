package com.runfeng.hibernate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 帝 on 2017/3/31.
 */
public class HqlQueryTest {
    @Test
    public void findEmployeeInfo() throws Exception {
        HqlQuery.findEmployeeInfo("all");
    }

}