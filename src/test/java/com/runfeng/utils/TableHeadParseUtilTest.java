package com.runfeng.utils;

import com.runfeng.hibernate.InformationEntity.EmployeesInfoHead;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/4/4.
 */
public class TableHeadParseUtilTest {
    @Test
    public void convertEmployeesInfoHeadToJson() throws Exception {
        System.out.println(TableHeadParseUtil.convertEmployeesInfoHeadToJson());
        /*Field[] fields = EmployeesInfoHead.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }*/
    }

}