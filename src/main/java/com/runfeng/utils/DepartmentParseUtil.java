package com.runfeng.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 帝 on 2017/4/3.
 */
class DepartmentParseUtil {

    public static Properties departmentParse(){
        Properties properties = new Properties();
        try {
            FileInputStream fin = new FileInputStream(new File("../../../basicR/Department.properties"));
            properties.load(fin);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            throw new RuntimeException("Department.properties don't exist!");
        }

    }
}
