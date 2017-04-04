package com.runfeng.utils;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by 帝 on 2017/4/3.
 */
public class DepartmentParseUtilTest {
    @Test
    public void departmentParse() throws Exception {
        String department = DepartmentParseUtil.departmentParse("eed");
        System.out.println(department);
    }

}