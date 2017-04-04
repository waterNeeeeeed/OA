package com.runfeng.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by 帝 on 2017/4/3.
 */
public class DepartmentParseUtil {

    public static String departmentParse(String key){
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Department", myLocale);

        return resourceBundle.getString(key);

    }
}
